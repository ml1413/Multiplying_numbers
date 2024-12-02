package com.multiplying_numbers.domain.multiple.repository

import com.multiplying_numbers.domain.multiple.models.ModelSingleTab

interface RepositorySingleTable {
    fun getTable(idTable: Int): ModelSingleTab
    fun checkLeftAnswer(modelSingleTab: ModelSingleTab): ModelSingleTab
    fun checkRightAnswer(modelSingleTab: ModelSingleTab): ModelSingleTab
    fun saveInStorage(modelSingleTab: ModelSingleTab)
    fun checkHistory(idTable: Int): Boolean
}