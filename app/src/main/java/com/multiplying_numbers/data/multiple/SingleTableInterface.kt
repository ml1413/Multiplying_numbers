package com.multiplying_numbers.data.multiple

import com.multiplying_numbers.domain.multiple.models.ModelItemTab

interface SingleTableInterface {
    fun getListTables(idTable: Int): ModelItemTab
    fun checkLeftAnswer(modelItemTab: ModelItemTab): ModelItemTab
    fun checkRightAnswer(modelItemTab: ModelItemTab): ModelItemTab
}