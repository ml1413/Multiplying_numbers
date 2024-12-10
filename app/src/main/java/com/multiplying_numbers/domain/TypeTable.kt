package com.multiplying_numbers.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
enum class TypeTable : Parcelable {
    MULTIPLE, DIVISION,ADDITION
}