package com.splanes.apps.toolboxcompose.ui_base.components.input.dropdown

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.splanes.apps.toolboxcompose.ui_base.utils.rememberStateOf
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> DropdownInput(
    items: List<T>,
    visuals: DropdownVisuals<T>,
    modifier: Modifier = Modifier,
    state: DropdownInputState<T> = rememberDropdownInputState(items.first()),
    colors: TextFieldColors = ExposedDropdownMenuDefaults.outlinedTextFieldColors(),
) {
    val scope = rememberCoroutineScope()
    var expanded by rememberStateOf(value = false)

    ExposedDropdownMenuBox(
        modifier = modifier,
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(),
            readOnly = true,
            value = visuals.itemName(state.selected),
            onValueChange = { },
            label = {
                Text(
                    text = visuals.label,
                    style = MaterialTheme.typography.bodyMedium,
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = visuals.itemIcon(state.selected),
                    contentDescription = visuals.itemContentDescription(state.selected),
                )
            },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            colors = colors
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            items.forEach { option ->
                DropdownMenuItem(
                    leadingIcon = {
                        Icon(
                            imageVector = visuals.itemIcon(option),
                            contentDescription = visuals.itemContentDescription(option),
                        )
                    },
                    text = {
                        Text(
                            text = visuals.itemName(option),
                            style = MaterialTheme.typography.bodyLarge,
                        )
                    },
                    onClick = {
                        scope.launch { state.onChange(option) }
                        expanded = false
                    },
                )
            }
        }
    }
}