package com.multiplying_numbers.domain.usecase.table_usecase.addition

import com.multiplying_numbers.domain.models.ModelTabForCard
import com.multiplying_numbers.domain.repository.RepositoryListTablesAddition
import javax.inject.Inject

class GetListTableAdditionUseCase @Inject constructor(
    private val repositoryListTablesAddition: RepositoryListTablesAddition
) {
    operator fun invoke(): List<ModelTabForCard> {
        return repositoryListTablesAddition.getListTablesAddition()
    }
}