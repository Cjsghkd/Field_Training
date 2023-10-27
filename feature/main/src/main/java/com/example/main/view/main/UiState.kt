package com.example.main.view.main

sealed interface UiState<out T> {
    object Loading: UiState<Nothing>

    object Error: UiState<Nothing>

    data class Success<T>(var data: T): UiState<T>
}