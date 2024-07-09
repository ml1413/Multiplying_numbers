package com.multiplying_numbers.domain.models

data class ModelQuestions(
    val id :Int ,
    val factor: Int,
    val num: Int,
    val questions: String,
    val answer :String,
    val isCorrect: Boolean? = null,
    val correctAnswer: Int
)