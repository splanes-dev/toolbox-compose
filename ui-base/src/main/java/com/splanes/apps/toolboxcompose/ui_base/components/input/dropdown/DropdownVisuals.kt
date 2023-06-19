package com.splanes.apps.toolboxcompose.ui_base.components.input.dropdown

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

data class DropdownVisuals<T>(
    val label: String,
    val itemName: (@Composable (T) -> String),
    val itemIcon: (@Composable (T) -> ImageVector),
    val itemContentDescription: (@Composable (T) -> String?) = { null }
)