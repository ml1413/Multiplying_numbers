package com.multiplying_numbers.domain.usecase.table_usecase.with_brackets

import com.multiplying_numbers.domain.models.ModelTabForCard
import com.multiplying_numbers.domain.repository.RepositoryTablesWithBrackets
import javax.inject.Inject

class GetListTablesWithBracketsUseCase @Inject constructor(
    private val repositoryTablesWithBrackets: RepositoryTablesWithBrackets
) {
    operator fun invoke(): List<ModelTabForCard> {
        return repositoryTablesWithBrackets.getListTables()
    }
}