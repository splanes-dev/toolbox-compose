package com.splanes.apps.toolboxcompose.ui_base.state

interface UiState {
    val loading: Boolean
    val error: Throwable?
}