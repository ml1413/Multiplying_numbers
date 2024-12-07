package com.multiplying_numbers.domain.multiple.models

data class TableParams(
    val paramsList: List<Params>,
    val idTable: Int
)

data class Params(
    val answerValue: Int,
    val questionString: String,
    val answerString: String,
    val id: Int,
)
