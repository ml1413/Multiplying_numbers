package com.multiplying_numbers.domain.multiple.usecase

import com.multiplying_numbers.domain.multiple.models.TableParams
import com.multiplying_numbers.domain.multiple.repository.RepositoryMultiple
import javax.inject.Inject

class GenerateParamsMultipleUseCase @Inject constructor(private val repositoryMultiple: RepositoryMultiple) {
    operator fun invoke(idTable: Int): TableParams {
        return repositoryMultiple.generateParams(idTable = idTable)
    }
}