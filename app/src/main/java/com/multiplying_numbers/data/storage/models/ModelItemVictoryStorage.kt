package com.multiplying_numbers.data.storage.models

import android.os.Parcelable
import com.multiplying_numbers.domain.models.ModelParameterForSave
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelItemVictoryStorage(
    var keyNameTable: String ,
    val label: String = "",
    val date: Long,
    val hasWrongAnswer: Boolean,
    val listAnswerStorage: List<ModelQuestionsStorage>
) : Parcelable
