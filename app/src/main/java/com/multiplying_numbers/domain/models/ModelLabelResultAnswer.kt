package com.multiplying_numbers.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelLabelResultAnswer(
    var keyNameTable: String = "",
    val date: Long,
    val hasWrongAnswer: Boolean,
) : Parcelable