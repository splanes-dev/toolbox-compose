package com.splanes.apps.toolboxcompose.ui_base.components.input.text

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

data class TextInputVisuals(
    val label: String,
    val placeholder: String? = null,
    val leadingIcon: ImageVector? = null,
    val inputType: InputType = InputType.Text,
    val imeAction: ImeAction = ImeAction.Default,
) {
    enum class InputType {
        Text,
        Email,
        Password,
        Url,
        Number,
    }

    fun transformation(isPlainText: Boolean): VisualTransformation {
        return if (inputType == InputType.Password && !isPlainText) {
            PasswordVisualTransformation()
        } else {
            VisualTransformation.None
        }
    }

    fun keyboardOptions() = KeyboardOptions(
        capitalization = when (inputType) {
            InputType.Text -> KeyboardCapitalization.Sentences
            InputType.Number,
            InputType.Url,
            InputType.Email,
            InputType.Password,
            -> KeyboardCapitalization.None
        },
        imeAction = imeAction,
        keyboardType = when (inputType) {
            InputType.Text -> KeyboardType.Text
            InputType.Email -> KeyboardType.Email
            InputType.Password -> KeyboardType.Password
            InputType.Url -> KeyboardType.Uri
            InputType.Number -> KeyboardType.Number
        },
    )
}
