package com.multiplying_numbers.data.multiple.repository

import com.multiplying_numbers.data.multiple.storage.sharedPref.StorageSharedPref
import com.multiplying_numbers.domain.multiple.models.ModelHistory
import com.multiplying_numbers.domain.multiple.repository.RepositoryHistoryAnswer
import javax.inject.Inject

class RepositoryHistoryAnswerImpl @Inject constructor(
    private val storageSharedPref: StorageSharedPref
) : RepositoryHistoryAnswer {
    override fun getHistoryFromStorage(idTable: Int): ModelHistory? {
       return storageSharedPref.getHistoryFromStorage(idTable = idTable)
    }
}