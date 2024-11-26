package com.multiplying_numbers.data.storage.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelQuestionsStorage(
    val id: Int,
    val factor: Int,
    val num: Int,
    val isAnimation: Boolean = false,
    val countWrongAnswer: Int = 0,
    val questions: String,
    val answer: String,
    val isCorrect: Boolean? = null,
    val correctAnswer: Int
) : Parcelable