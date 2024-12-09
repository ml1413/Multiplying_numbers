package com.multiplying_numbers.data.storage.sharedPref

import com.multiplying_numbers.domain.models.ModelHistory
import com.multiplying_numbers.domain.models.ModelSingleTab

interface StorageSharedPref {
    fun saveInStorage(modelSingleTab: ModelSingleTab)
    fun getHistoryFromStorage(keyStorage: String): ModelHistory?
    fun checkHistory(keyStorage: String): Boolean
}