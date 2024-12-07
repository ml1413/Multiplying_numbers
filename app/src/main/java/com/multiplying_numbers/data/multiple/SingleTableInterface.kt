package com.multiplying_numbers.data.multiple

import com.multiplying_numbers.domain.multiple.models.ModelSingleTab
import com.multiplying_numbers.domain.multiple.models.TableParams

interface SingleTableInterface {
    fun getListTables(tableParams: TableParams): ModelSingleTab
    fun checkLeftAnswer(modelSingleTab: ModelSingleTab): ModelSingleTab
    fun checkRightAnswer(modelSingleTab: ModelSingleTab): ModelSingleTab
}