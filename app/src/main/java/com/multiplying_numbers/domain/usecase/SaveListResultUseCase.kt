package com.multiplying_numbers.domain.usecase

import com.multiplying_numbers.domain.models.ModelParameterForSave
import com.multiplying_numbers.domain.repository.RepositoryListResult

class SaveListResultUseCase(private val repositoryListResult: RepositoryListResult) {
    operator fun invoke(modelParameterForSave: ModelParameterForSave, keyName: String) {
        repositoryListResult.save(modelParameterForSave = modelParameterForSave, keyName = keyName)
    }
}