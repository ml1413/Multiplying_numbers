package com.multiplying_numbers.data.multiple.storage.sharedPref

import com.multiplying_numbers.domain.multiple.models.ColorCountWrongAnswer
import com.multiplying_numbers.domain.multiple.models.ModelQuestions

data class ModelHistory(
    val listHistory: List<ItemHistory> = emptyList()
)

data class ItemHistory(
    val hasWrongAnswer: Boolean,
    val label: Int,
    val date: Long,
    val listAnswer: List<ModelQuestions>,
    val colorCountWrongAnswer: ColorCountWrongAnswer = ColorCountWrongAnswer.COLOR_DEFAULT
)