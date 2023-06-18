package com.splanes.apps.toolboxcompose.ui_base.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun <T> rememberStateOf(value: T) = remember {
    mutableStateOf(value)
}