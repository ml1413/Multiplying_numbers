package com.multiplying_numbers.domain.usecase.table_usecase.multiple


import com.multiplying_numbers.domain.models.ModelTabForCard
import com.multiplying_numbers.domain.repository.RepositoryListTablesMultiple
import javax.inject.Inject

class GetListTablesMultipleUseCase @Inject constructor(private val repositoryListTablesMultiple: RepositoryListTablesMultiple) {
    operator fun invoke(): List<ModelTabForCard> {
        return repositoryListTablesMultiple.getListTablesMultiple()
    }
}