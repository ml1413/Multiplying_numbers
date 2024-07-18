package com.multiplying_numbers.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelParameterForSave(
    val listModelItemVictory: List<ModelItemVictory>
) : Parcelable