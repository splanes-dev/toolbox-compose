package com.splanes.apps.toolboxcompose.ui_base.components.state

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.WarningAmber
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.splanes.apps.toolboxcompose.ui_base.components.buttons.Button
import com.splanes.apps.toolboxcompose.ui_base.components.loading.LoadingLayout
import com.splanes.apps.toolboxcompose.ui_base.components.loading.LoadingVisuals
import com.splanes.apps.toolboxcompose.ui_base.utils.rememberStateOf

@Composable
fun StateLayout(
    modifier: Modifier = Modifier,
    visuals: StateLayoutVisuals = StateLayoutVisuals(),
    onAcceptError: () -> Unit,
    content: @Composable () -> Unit
) {
    var isErrorDialogVisible by rememberStateOf(value = visuals.errorVisuals != null)

    Box(modifier = modifier.fillMaxSize()) {
        LoadingLayout(
            visible = visuals.loading,
            visuals = visuals.loadingVisuals
        ) {
            content()
        }
        if (isErrorDialogVisible) {
            val errorVisuals = visuals.errorVisuals ?: return

            AlertDialog(
                icon = {
                    Icon(
                        imageVector = errorVisuals.icon,
                        contentDescription = null,
                    )
                },
                title = errorVisuals.title?.let { title ->
                    {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.headlineMedium
                        )
                    }
                },
                text = {
                    Text(
                        text = errorVisuals.description,
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                shape = RoundedCornerShape(16.dp),
                onDismissRequest = {
                    isErrorDialogVisible = false
                    onAcceptError()
                },
                confirmButton = {
                    Button(
                        text = errorVisuals.confirmButton,
                        onClick = {
                            isErrorDialogVisible = false
                            onAcceptError()
                        }
                    )
                },
            )
        }
    }

    LaunchedEffect(visuals.errorVisuals) { isErrorDialogVisible = visuals.errorVisuals != null }
}

data class StateLayoutVisuals(
    val loading: Boolean = false,
    val loadingVisuals: LoadingVisuals = LoadingVisuals.Spinner(),
    val errorVisuals: ErrorVisuals? = null
)

data class ErrorVisuals(
    val icon: ImageVector = Icons.Rounded.WarningAmber,
    val title: String?,
    val description: String,
    val confirmButton: String,
)