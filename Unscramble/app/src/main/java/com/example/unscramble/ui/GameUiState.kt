package com.example.unscramble.ui

data class GameUiState(
    val currentScrambledWorld: String = "",
    val isGuessedWordWrong: Boolean = false,
    val score: Int = 0,
    val currentWordCount: Int = 1,
    val isGameOver: Boolean = false
)
