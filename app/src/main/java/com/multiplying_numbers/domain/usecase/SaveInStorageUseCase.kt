package com.multiplying_numbers.domain.usecase

import com.multiplying_numbers.domain.models.ModelSingleTab
import com.multiplying_numbers.domain.repository.RepositorySingleTable
import javax.inject.Inject

class SaveInStorageUseCase @Inject constructor(private val repositorySingleTable: RepositorySingleTable) {
    operator fun invoke(modelSingleTab: ModelSingleTab) {
        repositorySingleTable.saveInStorage(modelSingleTab = modelSingleTab)
    }
}