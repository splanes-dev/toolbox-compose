package com.splanes.apps.toolbox.components.bottomsheet

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

object BottomSheetDefaults {

    val Shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp)
    val BackgroundColor
        @Composable
        get () = MaterialTheme.colorScheme.surface

    val ContentColor
        @Composable
        get () = MaterialTheme.colorScheme.onSurface
}