package com.multiplying_numbers.domain.multiple.usecase


import com.multiplying_numbers.domain.multiple.models.ModelTabForCard
import com.multiplying_numbers.domain.multiple.repository.RepositoryListTables
import javax.inject.Inject

class GetListTablesUseCase @Inject constructor(private val repositoryListTables: RepositoryListTables) {
    operator fun invoke(): List<ModelTabForCard> {
        return repositoryListTables.getListTables()
    }
}