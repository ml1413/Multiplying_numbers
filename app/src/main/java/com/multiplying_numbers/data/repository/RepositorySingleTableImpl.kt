package com.multiplying_numbers.data.repository

import com.multiplying_numbers.data.storage.MultipleNum
import com.multiplying_numbers.data.storage.sharedPref.StorageSharedPref
import com.multiplying_numbers.domain.models.ModelItemTab
import com.multiplying_numbers.domain.repository.RepositorySingleTable
import javax.inject.Inject

class RepositorySingleTableImpl @Inject constructor(
    private val multipleNum: MultipleNum,
    private val storageSharedPref: StorageSharedPref
) : RepositorySingleTable {
    override fun getTable(idTable: Int): ModelItemTab {
        return multipleNum.getListTables(idTable = idTable)
    }

    override fun checkLeftAnswer(modelItemTab: ModelItemTab): ModelItemTab {
        return multipleNum.checkLeftAnswer(modelItemTab = modelItemTab)
    }

    override fun checkRightAnswer(modelItemTab: ModelItemTab): ModelItemTab {
        return multipleNum.checkRightAnswer(modelItemTab = modelItemTab)
    }

    override fun saveInStorage(modelItemTab: ModelItemTab) {
        storageSharedPref.saveInStorage(modelItemTab = modelItemTab)
    }
}