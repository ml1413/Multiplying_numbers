package com.multiplying_numbers.domain.models

data class ModelQuestions(
    val label: String,
    val num: Int,
    val question: String = "",
    val answer: Int = 0,
    val isCorrect: Boolean = false
)