package com.splanes.apps.toolboxcompose.ui_base.components.emptystate

import androidx.annotation.RawRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.splanes.apps.toolboxcompose.ui_base.R
import com.splanes.apps.toolboxcompose.ui_base.components.animation.LottieAnimation

@Composable
fun EmptyState(
    title: String,
    modifier: Modifier = Modifier,
    @RawRes animRes: Int = R.raw.anim_empty_state,
    animationSize: Dp = 200.dp,
    description: String? = null,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LottieAnimation(
            modifier = Modifier.size(animationSize),
            resource = animRes,
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
        )

        description?.let {
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = description,
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
            )
        }
    }
}