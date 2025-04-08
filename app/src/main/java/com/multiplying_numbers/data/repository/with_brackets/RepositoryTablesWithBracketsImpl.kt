package com.multiplying_numbers.data.repository.with_brackets

import com.multiplying_numbers.data.with_brackets.GetStartedListTablesWithBrackets
import com.multiplying_numbers.domain.models.ModelTabForCard
import com.multiplying_numbers.domain.repository.RepositoryTablesWithBrackets
import javax.inject.Inject

class RepositoryTablesWithBracketsImpl @Inject constructor(
    private val getStartedListTablesWithBrackets: GetStartedListTablesWithBrackets
) : RepositoryTablesWithBrackets {
    override fun getListTables(): List<ModelTabForCard> {
        return getStartedListTablesWithBrackets.getTablesWithBrackets()
    }
}