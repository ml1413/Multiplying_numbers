package com.multiplying_numbers.data

import com.multiplying_numbers.domain.models.ModelSingleTab
import com.multiplying_numbers.domain.models.TableParams

interface SingleTableInterface {
    fun getListTables(tableParams: TableParams): ModelSingleTab
    fun checkLeftAnswer(modelSingleTab: ModelSingleTab): ModelSingleTab
    fun checkRightAnswer(modelSingleTab: ModelSingleTab): ModelSingleTab
}