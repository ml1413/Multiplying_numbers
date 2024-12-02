package com.multiplying_numbers.data.multiple.repository

import com.multiplying_numbers.data.multiple.SingleTableInterface
import com.multiplying_numbers.data.multiple.storage.sharedPref.StorageSharedPref
import com.multiplying_numbers.domain.multiple.models.ModelItemTab
import com.multiplying_numbers.domain.multiple.repository.RepositorySingleTable
import javax.inject.Inject

class RepositorySingleTableImpl @Inject constructor(
    private val singleTableInterface: SingleTableInterface,
    private val storageSharedPref: StorageSharedPref
) : RepositorySingleTable {
    override fun getTable(idTable: Int): ModelItemTab {
        return singleTableInterface.getListTables(idTable = idTable)
    }

    override fun checkLeftAnswer(modelItemTab: ModelItemTab): ModelItemTab {
        return singleTableInterface.checkLeftAnswer(modelItemTab = modelItemTab)
    }

    override fun checkRightAnswer(modelItemTab: ModelItemTab): ModelItemTab {
        return singleTableInterface.checkRightAnswer(modelItemTab = modelItemTab)
    }

    override fun saveInStorage(modelItemTab: ModelItemTab) {
        storageSharedPref.saveInStorage(modelItemTab = modelItemTab)
    }
}