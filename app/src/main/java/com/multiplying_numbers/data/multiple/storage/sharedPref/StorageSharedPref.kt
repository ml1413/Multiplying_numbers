package com.multiplying_numbers.data.multiple.storage.sharedPref

import com.multiplying_numbers.domain.multiple.models.ModelHistory
import com.multiplying_numbers.domain.multiple.models.ModelItemTab

interface StorageSharedPref {
    fun saveInStorage(modelItemTab: ModelItemTab)
    fun getHistoryFromStorage(idTable: Int): ModelHistory?
}