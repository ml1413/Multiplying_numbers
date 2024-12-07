package com.multiplying_numbers.domain.multiple.repository

import com.multiplying_numbers.domain.multiple.models.ModelSingleTab
import com.multiplying_numbers.domain.multiple.models.TableParams

interface RepositorySingleTable {
    fun getTable(tableParams: TableParams): ModelSingleTab
    fun checkLeftAnswer(modelSingleTab: ModelSingleTab): ModelSingleTab
    fun checkRightAnswer(modelSingleTab: ModelSingleTab): ModelSingleTab
    fun saveInStorage(modelSingleTab: ModelSingleTab)
    fun checkHistory(keyStorage: String): Boolean
}