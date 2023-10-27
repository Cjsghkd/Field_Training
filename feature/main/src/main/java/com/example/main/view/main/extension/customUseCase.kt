package com.example.main.view.main.extension

import com.example.main.view.main.UiState
import kotlinx.coroutines.flow.MutableStateFlow

fun <T> Result<T>.customUseCase(uiState: MutableStateFlow<UiState<T>>) {
    this.onSuccess {
        uiState.value = UiState.Success(it)
    }.onFailure {
        uiState.value = UiState.Error
    }
}