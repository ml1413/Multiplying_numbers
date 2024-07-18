package com.multiplying_numbers.domain.usecase

import com.multiplying_numbers.domain.models.ModelParameterForSave
import com.multiplying_numbers.domain.repository.RepositoryListResult

class GetListResultUseCase(private val repositoryListResult: RepositoryListResult) {
    operator fun invoke(keyName: String): ModelParameterForSave? {
        return repositoryListResult.get(keyName = keyName)
    }
}