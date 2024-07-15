package com.multiplying_numbers.data.repository

import com.multiplying_numbers.data.storage.StorageListResult
import com.multiplying_numbers.domain.models.ModelWrapper
import com.multiplying_numbers.domain.repository.RepositoryListResult

class RepositoryListResultImpl(private val storageListResult: StorageListResult) :
    RepositoryListResult {
    override fun saveList(listResult: List<ModelWrapper>, keyName: String) {
        storageListResult.saveList(listResult = listResult, keyName = keyName)
    }

    override fun getList(keyName: String): List<ModelWrapper>? {
        return storageListResult.getList(keyName = keyName)
    }
}