package com.splanes.apps.toolboxcompose.ui_base.components.input.text

import android.util.Patterns
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class TextInputState(private val initial: String) {

    var inputValue: TextInputValue by mutableStateOf(TextInputValue.Normal(initial))
        private set

    var hasChanged: Boolean by mutableStateOf(false)
        private set

    private val mutex: Mutex = Mutex()

    suspend fun onChange(text: String) = mutex.withLock {
        inputValue = TextInputValue.Normal(text)
        hasChanged = text != initial
    }

    suspend fun clear() = onChange("")

    suspend fun validate(vararg validators: TextInputValidator) = mutex.withLock {
        val validatorFailed = validators.find { v -> !v.isValid(inputValue.text.orEmpty()) }
        inputValue = validatorFailed?.let { failed ->
            TextInputValue.Error(inputValue.text, failed.error)
        } ?: TextInputValue.Normal(inputValue.text.orEmpty())
        inputValue !is TextInputValue.Error
    }
}

sealed class TextInputValue(open val text: String? = null) {

    val isEmpty: Boolean get() = text.orEmpty().isBlank()

    data class Normal(override val text: String) : TextInputValue(text)

    data class Error(override val text: String?, val error: String) : TextInputValue(text)
}

interface TextInputValidator {
    val error: String
    fun isValid(input: String): Boolean

    data class Mandatory(override val error: String) : TextInputValidator {
        private val regex = Regex("^.*(\\w)+.*$")
        override fun isValid(input: String): Boolean = regex.matches(input)
    }

    data class Email(override val error: String) : TextInputValidator {
        private val regex = Patterns.EMAIL_ADDRESS.pattern().toRegex()
        override fun isValid(input: String): Boolean = regex.matches(input)
    }

    data class Password(override val error: String) : TextInputValidator {
        private val regex = Regex("^.*(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}.*$")
        override fun isValid(input: String): Boolean = regex.matches(input)
    }

    companion object
}

@Composable
fun rememberTextInputState(initial: String = "") = remember { TextInputState(initial) }
