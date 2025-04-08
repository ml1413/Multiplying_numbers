package com.multiplying_numbers.data.repository.multiple

import com.multiplying_numbers.data.multiple.GetStartedListTablesMultiple
import com.multiplying_numbers.domain.models.ModelTabForCard
import com.multiplying_numbers.domain.repository.RepositoryListTablesMultiple
import javax.inject.Inject

class RepositoryListTablesMultipleMultipleImpl @Inject constructor(
    private val getStartedListTablesMultiple: GetStartedListTablesMultiple
) : RepositoryListTablesMultiple {
    override fun getListTablesMultiple(): List<ModelTabForCard> {
        return getStartedListTablesMultiple.getListTables()
    }


}