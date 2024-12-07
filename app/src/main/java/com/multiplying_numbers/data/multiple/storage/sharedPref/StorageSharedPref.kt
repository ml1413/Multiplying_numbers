package com.multiplying_numbers.data.multiple.storage.sharedPref

import com.multiplying_numbers.domain.multiple.models.ModelHistory
import com.multiplying_numbers.domain.multiple.models.ModelSingleTab

interface StorageSharedPref {
    fun saveInStorage(modelSingleTab: ModelSingleTab)
    fun getHistoryFromStorage(keyStorage: String): ModelHistory?
    fun checkHistory(keyStorage: String): Boolean
}