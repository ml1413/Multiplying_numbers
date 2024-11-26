package com.multiplying_numbers.domain.models

import android.os.Parcelable
import com.multiplying_numbers.data.storage.models.ModelItemVictoryStorage
import com.multiplying_numbers.data.storage.models.ModelParameterForSaveStorage
import com.multiplying_numbers.data.storage.models.ModelQuestionsStorage
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelParameterForSave(
    val listModelItemVictory: List<ModelItemVictory>
) : Parcelable



