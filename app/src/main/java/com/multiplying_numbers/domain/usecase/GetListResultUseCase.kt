package com.multiplying_numbers.domain.usecase

import com.multiplying_numbers.domain.models.ModelWrapper
import com.multiplying_numbers.domain.repository.RepositoryListResult

class GetListResultUseCase(private val repositoryListResult: RepositoryListResult) {
    operator fun invoke(keyName: String): List<ModelWrapper>? {
        return repositoryListResult.getList(keyName = keyName)
    }
}