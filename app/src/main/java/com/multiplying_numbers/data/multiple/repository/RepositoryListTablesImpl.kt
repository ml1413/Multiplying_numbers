package com.multiplying_numbers.data.multiple.repository

import com.multiplying_numbers.data.multiple.GetStartedListTables
import com.multiplying_numbers.domain.multiple.models.ModelTabForCard
import com.multiplying_numbers.domain.multiple.repository.RepositoryListTables
import javax.inject.Inject

class RepositoryListTablesImpl @Inject constructor(
    private val getStartedListTables: GetStartedListTables
) : RepositoryListTables {
    override fun getListTables(): List<ModelTabForCard> {
        return getStartedListTables.getListTables()
    }
}