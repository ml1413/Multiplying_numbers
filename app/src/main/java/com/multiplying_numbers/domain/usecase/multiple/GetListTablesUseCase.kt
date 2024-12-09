package com.multiplying_numbers.domain.usecase.multiple


import com.multiplying_numbers.domain.models.multiple.ModelTabForCard
import com.multiplying_numbers.domain.repository.multiple.RepositoryListTables
import javax.inject.Inject

class GetListTablesUseCase @Inject constructor(private val repositoryListTables: RepositoryListTables) {
    operator fun invoke(): List<ModelTabForCard> {
        return repositoryListTables.getListTables()
    }
}