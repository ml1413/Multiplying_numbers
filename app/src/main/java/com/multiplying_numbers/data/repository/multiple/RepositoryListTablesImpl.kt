package com.multiplying_numbers.data.repository.multiple

import com.multiplying_numbers.data.multiole.GetStartedListTables
import com.multiplying_numbers.domain.models.multiple.ModelTabForCard
import com.multiplying_numbers.domain.models.TableParams
import com.multiplying_numbers.domain.repository.multiple.RepositoryListTables
import javax.inject.Inject

class RepositoryListTablesImpl @Inject constructor(
    private val getStartedListTables: GetStartedListTables
) : RepositoryListTables {
    override fun getListTables(): List<ModelTabForCard> {
        return getStartedListTables.getListTables()
    }

    override fun generateTableParams(idTable: Int): TableParams {
        return getStartedListTables.generateTableParams(idTable = idTable)
    }
}