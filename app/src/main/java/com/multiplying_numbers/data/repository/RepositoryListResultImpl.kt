package com.multiplying_numbers.data.repository

import com.multiplying_numbers.data.storage.StorageListResult
import com.multiplying_numbers.domain.models.ModelParameterForSave
import com.multiplying_numbers.domain.models.ModelWrapper
import com.multiplying_numbers.domain.repository.RepositoryListResult

class RepositoryListResultImpl(private val storageListResult: StorageListResult) :
    RepositoryListResult {
    override fun save(modelParameterForSave: ModelParameterForSave, keyName: String) {
        storageListResult.save(modelParameterForSave, keyName = keyName)
    }

    override fun get(keyName: String): ModelParameterForSave? {
        return storageListResult.get(keyName = keyName)
    }
}