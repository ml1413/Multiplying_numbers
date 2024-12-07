package com.multiplying_numbers.data.multiple.repository

import com.multiplying_numbers.data.multiple.SingleTableInterface
import com.multiplying_numbers.data.multiple.storage.sharedPref.StorageSharedPref
import com.multiplying_numbers.domain.multiple.models.ModelSingleTab
import com.multiplying_numbers.domain.multiple.models.TableParams
import com.multiplying_numbers.domain.multiple.repository.RepositorySingleTable
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

    override fun checkHistory(idTable: Int): Boolean {
      return  storageSharedPref.checkHistory(idTable = idTable)
    }
}