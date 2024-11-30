package com.multiplying_numbers.data.storage

import com.multiplying_numbers.domain.models.ModelItemTab

interface MultipleNum {
    fun getListTables(idTable: Int): ModelItemTab
    fun checkLeftAnswer(modelItemTab: ModelItemTab): ModelItemTab
    fun checkRightAnswer(modelItemTab: ModelItemTab): ModelItemTab
}