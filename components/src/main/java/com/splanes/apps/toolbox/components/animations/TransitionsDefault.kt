package com.splanes.apps.toolbox.components.animations

import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkHorizontally
import androidx.compose.animation.shrinkVertically
import androidx.compose.ui.Alignment

object TransitionsDefault {

    const val ShortTweenMillis = 300
    const val MediumTweenMillis = 700
    const val LongTweenMillis = 1000

    val FadeIn = fadeIn(tween(MediumTweenMillis))

    val FadeOut = fadeOut(tween(MediumTweenMillis))

    val ExpandVerticallyFromBottom = expandVertically(
        animationSpec = tween(MediumTweenMillis),
        expandFrom = Alignment.Bottom
    )

    val ExpandVerticallyFromTop = expandVertically(
        animationSpec = tween(MediumTweenMillis),
        expandFrom = Alignment.Top
    )

    val ExpandHorizontallyFromStart = expandHorizontally(
        animationSpec = tween(MediumTweenMillis),
        expandFrom = Alignment.Start
    )

    val ExpandHorizontallyFromEnd = expandHorizontally(
        animationSpec = tween(MediumTweenMillis),
        expandFrom = Alignment.End
    )

    val ShrinkVerticallyTowardsBottom = shrinkVertically(
        animationSpec = tween(MediumTweenMillis),
        shrinkTowards = Alignment.Bottom
    )

    val ShrinkVerticallyTowardsTop = shrinkVertically(
        animationSpec = tween(MediumTweenMillis),
        shrinkTowards = Alignment.Top
    )

    val ShrinkHorizontallyTowardsStart = shrinkHorizontally(
        animationSpec = tween(MediumTweenMillis),
        shrinkTowards = Alignment.Start
    )

    val ShrinkHorizontallyTowardsEnd = shrinkHorizontally(
        animationSpec = tween(MediumTweenMillis),
        shrinkTowards = Alignment.End
    )
}