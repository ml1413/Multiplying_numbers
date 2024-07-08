package com.multiplying_numbers.domain.usecase

import com.multiplying_numbers.domain.models.ModelQuestions
import com.multiplying_numbers.domain.repository.RepositoryListTables

class GetListTablesUseCase(private val repositoryListTables: RepositoryListTables) {
    operator fun invoke(): List<List<ModelQuestions>> {
        return repositoryListTables.getListTables()
    }
}