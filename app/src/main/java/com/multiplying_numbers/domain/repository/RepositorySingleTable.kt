package com.multiplying_numbers.domain.repository

import com.multiplying_numbers.domain.models.ModelSingleTab
import com.multiplying_numbers.domain.models.TableParams

interface RepositorySingleTable {
    fun getTable(tableParams: TableParams): ModelSingleTab
    fun checkLeftAnswer(modelSingleTab: ModelSingleTab): ModelSingleTab
    fun checkRightAnswer(modelSingleTab: ModelSingleTab): ModelSingleTab
    fun saveInStorage(modelSingleTab: ModelSingleTab)
    fun checkHistory(keyStorage: String): Boolean
}