package com.multiplying_numbers.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelQuestions(
    val id: Int,
    val factor: Int,
    val num: Int,
    val countWrongAnswer: Int = 0,
    val questions: String,
    val answer: String,
    val isCorrect: Boolean? = null,
    val correctAnswer: Int
) : Parcelable