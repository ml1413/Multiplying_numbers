package com.multiplying_numbers.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelItemVictory(
    var keyNameTable: String ,
    val label: String = "",
    val date: Long,
    val hasWrongAnswer: Boolean,
    val listAnswer: List<ModelQuestions>
) : Parcelable