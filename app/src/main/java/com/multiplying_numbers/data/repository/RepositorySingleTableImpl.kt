package com.multiplying_numbers.data.repository

import com.multiplying_numbers.data.SingleTableInterface
import com.multiplying_numbers.data.storage.sharedPref.StorageSharedPref
import com.multiplying_numbers.domain.models.ModelSingleTab
import com.multiplying_numbers.domain.models.TableParams
import com.multiplying_numbers.domain.repository.RepositorySingleTable
import javax.inject.Inject

class RepositorySingleTableImpl @Inject constructor(
    private val singleTableInterface: SingleTableInterface,
    private val storageSharedPref: StorageSharedPref
) : RepositorySingleTable {
    override fun getTable(tableParams: TableParams): ModelSingleTab {
        return singleTableInterface.getListTables(tableParams = tableParams)
    }

    override fun checkLeftAnswer(modelSingleTab: ModelSingleTab): ModelSingleTab {
        return singleTableInterface.checkLeftAnswer(modelSingleTab = modelSingleTab)
    }

    override fun checkRightAnswer(modelSingleTab: ModelSingleTab): ModelSingleTab {
        return singleTableInterface.checkRightAnswer(modelSingleTab = modelSingleTab)
    }

    override fun saveInStorage(modelSingleTab: ModelSingleTab) {
        storageSharedPref.saveInStorage(modelSingleTab = modelSingleTab)
    }

    override fun checkHistory(keyStorage: String): Boolean {
      return  storageSharedPref.checkHistory(keyStorage = keyStorage)
    }
}