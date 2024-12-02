package com.multiplying_numbers.domain.multiple.usecase

import com.multiplying_numbers.domain.multiple.models.ModelItemTab
import com.multiplying_numbers.domain.multiple.repository.RepositorySingleTable
import javax.inject.Inject

class SaveInStorageUseCase @Inject constructor(private val repositorySingleTable: RepositorySingleTable) {
    operator fun invoke(modelItemTab: ModelItemTab) {
        repositorySingleTable.saveInStorage(modelItemTab = modelItemTab)
    }
}