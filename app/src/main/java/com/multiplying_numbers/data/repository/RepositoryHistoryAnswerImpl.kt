package com.multiplying_numbers.data.repository

import com.multiplying_numbers.data.storage.sharedPref.StorageSharedPref
import com.multiplying_numbers.domain.models.ModelHistory
import com.multiplying_numbers.domain.repository.RepositoryHistoryAnswer
import javax.inject.Inject

class RepositoryHistoryAnswerImpl @Inject constructor(
    private val storageSharedPref: StorageSharedPref
) : RepositoryHistoryAnswer {
    override fun getHistoryFromStorage(keyStorage: String): ModelHistory? {
       return storageSharedPref.getHistoryFromStorage(keyStorage = keyStorage)
    }
}