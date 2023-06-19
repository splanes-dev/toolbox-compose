package com.splanes.apps.toolboxcompose.ui_base.components.input.text

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Cancel
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.splanes.apps.toolboxcompose.ui_base.R
import com.splanes.apps.toolboxcompose.ui_base.utils.rememberStateOf
import kotlinx.coroutines.launch

@Composable
fun TextInput(
    state: TextInputState,
    visuals: TextInputVisuals,
    modifier: Modifier = Modifier,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(),
    enabled: Boolean = true,
) {
    val inputValue = state.inputValue
    val coroutineScope = rememberCoroutineScope()
    var focused by rememberStateOf(value = false)
    var plainText by rememberStateOf(value = false)

    Column(modifier) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .onFocusEvent { focusState -> focused = focusState.hasFocus },
            value = inputValue.text.orEmpty(),
            onValueChange = { value -> coroutineScope.launch { state.onChange(value) } },
            label = { Text(text = visuals.label, style = MaterialTheme.typography.bodyMedium) },
            placeholder = {
                visuals.placeholder?.let { placeholder ->
                    Text(text = placeholder, style = MaterialTheme.typography.titleSmall)
                }
            },
            leadingIcon = visuals.leadingIcon?.let { leadingIcon ->
                {
                    Crossfade(targetState = focused, label = "") { hasFocus ->
                        Icon(
                            modifier = Modifier.size(24.dp),
                            imageVector = leadingIcon,
                            contentDescription = visuals.label,
                            tint = MaterialTheme.colorScheme.run {
                                when (inputValue) {
                                    is TextInputValue.Normal -> {
                                        if (hasFocus) primary else onSurface.copy(alpha = .7f)
                                    }

                                    is TextInputValue.Error -> {
                                        if (hasFocus) error else error.copy(alpha = .7f)
                                    }
                                }
                            },
                        )
                    }
                }
            },
            trailingIcon = {
                when (visuals.inputType) {
                    TextInputVisuals.InputType.Url,
                    TextInputVisuals.InputType.Number,
                    TextInputVisuals.InputType.Text,
                    TextInputVisuals.InputType.Email,
                    -> {
                        AnimatedVisibility(
                            visible = focused && !inputValue.isEmpty,
                            enter = fadeIn(animationSpec = tween(ANIMATION_MILLIS)),
                            exit = fadeOut(animationSpec = tween(ANIMATION_MILLIS)),
                        ) {
                            IconButton(onClick = { coroutineScope.launch { state.clear() } }) {
                                Icon(
                                    modifier = Modifier.size(24.dp),
                                    imageVector = Icons.Rounded.Cancel,
                                    contentDescription = stringResource(id = R.string.clear),
                                    tint = MaterialTheme.colorScheme.onSurface.copy(alpha = .7f),
                                )
                            }
                        }
                    }

                    TextInputVisuals.InputType.Password -> {
                        AnimatedVisibility(
                            visible = focused,
                            enter = fadeIn(animationSpec = tween(ANIMATION_MILLIS)),
                            exit = fadeOut(animationSpec = tween(ANIMATION_MILLIS)),
                        ) {
                            Crossfade(targetState = plainText, label = "") { isPlainText ->
                                IconButton(onClick = { plainText = !plainText }) {
                                    Icon(
                                        modifier = Modifier.size(24.dp),
                                        imageVector = if (isPlainText) {
                                            Icons.Rounded.VisibilityOff
                                        } else {
                                            Icons.Rounded.Visibility
                                        },
                                        contentDescription = stringResource(id = R.string.clear),
                                        tint = MaterialTheme.colorScheme.onSurface.copy(alpha = .7f),
                                    )
                                }
                            }
                        }
                    }
                }
            },
            visualTransformation = visuals.transformation(plainText),
            colors = colors,
            keyboardOptions = visuals.keyboardOptions(),
            singleLine = true,
            isError = inputValue is TextInputValue.Error,
            enabled = enabled,
        )
        AnimatedVisibility(
            visible = inputValue is TextInputValue.Error,
            enter = expandVertically(
                animationSpec = tween(ANIMATION_MILLIS),
                expandFrom = Alignment.Top,
            ),
            exit = shrinkVertically(
                animationSpec = tween(ANIMATION_MILLIS),
                shrinkTowards = Alignment.Top,
            ),
        ) {
            (inputValue as? TextInputValue.Error)?.let { errorValue ->
                Text(
                    modifier = Modifier.padding(top = 4.dp),
                    text = errorValue.error,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.error,
                )
            }
        }
    }
}

private const val ANIMATION_MILLIS = 300