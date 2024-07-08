package com.multiplying_numbers.domain.models

data class ModelQuestions(
    val id: Int,
    val num:Int,
    val questions: String,
    val isCorrect: Boolean? = null
)