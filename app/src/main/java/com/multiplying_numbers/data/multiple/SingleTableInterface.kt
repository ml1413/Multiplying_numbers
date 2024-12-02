package com.multiplying_numbers.data.multiple

import com.multiplying_numbers.domain.multiple.models.ModelSingleTab

interface SingleTableInterface {
    fun getListTables(idTable: Int): ModelSingleTab
    fun checkLeftAnswer(modelSingleTab: ModelSingleTab): ModelSingleTab
    fun checkRightAnswer(modelSingleTab: ModelSingleTab): ModelSingleTab
}