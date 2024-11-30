package com.multiplying_numbers.domain.usecase


import com.multiplying_numbers.domain.models.ModelTabForCard
import com.multiplying_numbers.domain.repository.RepositoryListTables
import javax.inject.Inject

class GetListTablesUseCase @Inject constructor(private val repositoryListTables: RepositoryListTables) {
    operator fun invoke(): List<ModelTabForCard> {
        return repositoryListTables.getListTables()
    }
}