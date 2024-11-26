package com.multiplying_numbers.data.storage.models

import android.os.Parcelable
import com.multiplying_numbers.domain.models.ModelItemVictory
import com.multiplying_numbers.domain.models.ModelParameterForSave
import com.multiplying_numbers.domain.models.ModelQuestions
import kotlinx.parcelize.Parcelize

@Parcelize
data class ModelParameterForSaveStorage(
    val listModelItemVictoryStorage: List<ModelItemVictoryStorage>
) : Parcelable


