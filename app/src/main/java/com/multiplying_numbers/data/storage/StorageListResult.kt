package com.multiplying_numbers.data.storage

import com.multiplying_numbers.domain.models.ModelWrapper
import com.multiplying_numbers.domain.repository.RepositoryListResult

interface StorageListResult {
    fun saveList(listResult: List<ModelWrapper>,keyName:String)
    fun getList(keyName: String):List<ModelWrapper>?
}