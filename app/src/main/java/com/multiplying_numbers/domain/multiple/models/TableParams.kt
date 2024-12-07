package com.multiplying_numbers.domain.multiple.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TableParams(
    val paramsList: List<Params>,
    val idTable: Int
) : Parcelable

@Parcelize
data class Params(
    val answerValue: Int,
    val questionString: String,
    val answerString: String,
    val id: Int,
) : Parcelable
