package com.splanes.apps.toolbox.components.animations

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.runtime.Composable

@Composable
fun FadeInOutVisibility(
    visible: Boolean,
    content: @Composable AnimatedVisibilityScope.() -> Unit
) {
    AnimatedVisibility(
        visible = visible,
        enter = TransitionsDefault.FadeIn,
        exit = TransitionsDefault.FadeOut,
        content = content
    )
}