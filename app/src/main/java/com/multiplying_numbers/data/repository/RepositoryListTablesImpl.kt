package com.multiplying_numbers.data.repository

import com.multiplying_numbers.data.storage.GetListTables
import com.multiplying_numbers.domain.models.ModelTabForCard
import com.multiplying_numbers.domain.repository.RepositoryListTables
import javax.inject.Inject

class RepositoryListTablesImpl @Inject constructor(
    private val getListTables: GetListTables
) : RepositoryListTables {
    override fun getListTables(): List<ModelTabForCard> {
        return getListTables.getListTables()
    }
}