package com.multiplying_numbers.domain.models

import com.multiplying_numbers.domain.models.ColorCountWrongAnswer
import com.multiplying_numbers.domain.models.ModelQuestions

data class ModelHistory(
    val listHistory: List<ItemHistory> = emptyList()
)

data class ItemHistory(
    val hasWrongAnswer: Boolean,
    val date: Long,
    val listAnswer: List<ModelQuestions>,
    val colorCountWrongAnswer: ColorCountWrongAnswer = ColorCountWrongAnswer.COLOR_DEFAULT
)