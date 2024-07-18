package com.multiplying_numbers.data.storage

import com.multiplying_numbers.domain.models.ModelParameterForSave

interface StorageListResult {
    fun save(modelParameterForSave: ModelParameterForSave, keyName: String)
    fun get(keyName: String): ModelParameterForSave?
}