package com.multiplying_numbers.data.repository

import com.multiplying_numbers.data.storage.GetListTables
import com.multiplying_numbers.domain.models.ModelQuestions2
import com.multiplying_numbers.domain.repository.RepositoryListTables

class RepositoryListTablesImpl(
    private val getListTables: GetListTables
) : RepositoryListTables {
    override fun getListTables(): List<List<ModelQuestions2>> {
        return getListTables.getListTables()
    }
}