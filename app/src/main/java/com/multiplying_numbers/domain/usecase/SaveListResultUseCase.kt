package com.multiplying_numbers.domain.usecase

import com.multiplying_numbers.domain.models.ModelWrapper
import com.multiplying_numbers.domain.repository.RepositoryListResult

class SaveListResultUseCase(private val repositoryListResult: RepositoryListResult) {
    operator fun invoke(listResult: List<ModelWrapper>, keyName: String) {
        repositoryListResult.saveList(listResult = listResult, keyName = keyName)
    }
}