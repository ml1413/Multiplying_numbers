package com.multiplying_numbers.domain.usecase.table_usecase.division

import com.multiplying_numbers.domain.models.ModelTabForCard
import com.multiplying_numbers.domain.repository.RepositoryListTablesDivision
import javax.inject.Inject

class GetListTableDivisionUseCase @Inject constructor(
    private val repositoryListTablesDivision: RepositoryListTablesDivision
) {
    operator fun invoke(): List<ModelTabForCard> {
        return repositoryListTablesDivision.getListTablesDivision()
    }
}