package com.splanes.apps.toolboxcompose.ui_base.components.buttons

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun Button(
    text: String,
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    onClick: () -> Unit
) {
    androidx.compose.material3.Button(
        modifier = modifier,
        colors = colors,
        onClick = onClick
    ) {
        leadingIcon?.let { icon ->
            Icon(
                imageVector = icon,
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(8.dp))
        }

        Text(
            text = text,
            style = MaterialTheme.typography.titleSmall
        )

        trailingIcon?.let { icon ->
            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                imageVector = icon,
                contentDescription = null
            )
        }
    }
}

@Composable
fun TextButton(
    text: String,
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.textButtonColors(),
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    onClick: () -> Unit
) {
    androidx.compose.material3.TextButton(
        modifier = modifier,
        colors = colors,
        onClick = onClick
    ) {
        leadingIcon?.let { icon ->
            Icon(
                imageVector = icon,
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(8.dp))
        }

        Text(
            text = text,
            style = MaterialTheme.typography.titleSmall
        )

        trailingIcon?.let { icon ->
            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                imageVector = icon,
                contentDescription = null
            )
        }
    }
}

@Composable
fun OutlinedButton(
    text: String,
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.outlinedButtonColors(),
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    onClick: () -> Unit
) {
    androidx.compose.material3.OutlinedButton(
        modifier = modifier,
        colors = colors,
        onClick = onClick
    ) {
        leadingIcon?.let { icon ->
            Icon(
                imageVector = icon,
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(8.dp))
        }

        Text(
            text = text,
            style = MaterialTheme.typography.titleSmall
        )

        trailingIcon?.let { icon ->
            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                imageVector = icon,
                contentDescription = null
            )
        }
    }
}

@Composable
fun ElevatedButton(
    text: String,
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.elevatedButtonColors(),
    elevation: ButtonElevation = ButtonDefaults.elevatedButtonElevation(),
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    onClick: () -> Unit
) {
    androidx.compose.material3.ElevatedButton(
        modifier = modifier,
        colors = colors,
        elevation = elevation,
        onClick = onClick
    ) {
        leadingIcon?.let { icon ->
            Icon(
                imageVector = icon,
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(8.dp))
        }

        Text(
            text = text,
            style = MaterialTheme.typography.titleSmall
        )

        trailingIcon?.let { icon ->
            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                imageVector = icon,
                contentDescription = null
            )
        }
    }
}