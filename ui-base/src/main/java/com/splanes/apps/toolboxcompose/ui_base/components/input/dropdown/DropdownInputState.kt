package com.splanes.apps.toolboxcompose.ui_base.components.input.dropdown

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class DropdownInputState<T>(initial: T) {

    var selected: T by mutableStateOf(initial)
        private set

    private val mutex: Mutex = Mutex()

    suspend fun onChange(value: T) = mutex.withLock {
        selected = value
    }
}

@Composable
fun <T> rememberDropdownInputState(initial: T) = remember {
    DropdownInputState(initial)
}