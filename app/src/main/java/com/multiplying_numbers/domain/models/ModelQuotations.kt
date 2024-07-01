package com.multiplying_numbers.domain.models

data class ModelQuestions(
    val id :Int=0,
    val label: String,// -2-
    val num: Int,// 2
    val questionOnTable: String = "",// 2 * 3 = ?
    val questionSingle: String = "",// 2 * 3 = 6
    val correctAnswer: Int = 0,// 6
    val randomAnswer: Int = 0,// 6+ random // int 0..2
    val isCorrect: Boolean? = null
)