package com.splanes.apps.toolboxcompose.ui_base.components.loading

import androidx.annotation.RawRes
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

sealed class LoadingVisuals(
    open val size: Dp,
    open val message: String?
) {

    data class Spinner(
        override val size: Dp = 50.dp,
        override val message: String? = null
    ) : LoadingVisuals(
        size = size,
        message = message
    )

    data class LottieAnimation(
        override val size: Dp = 125.dp,
        override val message: String? = null,
        @RawRes val animRes: Int,
    ) : LoadingVisuals(
        size = size,
        message = message
    )
}