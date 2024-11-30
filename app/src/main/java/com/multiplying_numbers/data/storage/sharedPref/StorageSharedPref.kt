package com.multiplying_numbers.data.storage.sharedPref

import com.multiplying_numbers.domain.models.ModelHistory
import com.multiplying_numbers.domain.models.ModelItemTab

interface StorageSharedPref {
    fun saveInStorage(modelItemTab: ModelItemTab)
    fun getHistoryFromStorage(idTable: Int): ModelHistory?
}