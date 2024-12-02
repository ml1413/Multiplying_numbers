package com.multiplying_numbers.domain.multiple.repository

import com.multiplying_numbers.domain.multiple.models.ModelItemTab

interface RepositorySingleTable {
    fun getTable(idTable: Int): ModelItemTab
    fun checkLeftAnswer(modelItemTab: ModelItemTab): ModelItemTab
    fun checkRightAnswer(modelItemTab: ModelItemTab): ModelItemTab
    fun saveInStorage(modelItemTab: ModelItemTab)
}