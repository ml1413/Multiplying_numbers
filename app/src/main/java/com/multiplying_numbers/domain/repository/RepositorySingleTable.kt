package com.multiplying_numbers.domain.repository

import com.multiplying_numbers.domain.models.ModelItemTab

interface RepositorySingleTable {
    fun getTable(idTable: Int): ModelItemTab
    fun checkLeftAnswer(modelItemTab: ModelItemTab): ModelItemTab
    fun checkRightAnswer(modelItemTab: ModelItemTab): ModelItemTab
    fun saveInStorage(modelItemTab: ModelItemTab)
}