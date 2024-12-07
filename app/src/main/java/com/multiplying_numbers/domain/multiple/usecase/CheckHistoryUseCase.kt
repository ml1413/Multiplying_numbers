package com.multiplying_numbers.domain.multiple.usecase

import com.multiplying_numbers.domain.multiple.repository.RepositorySingleTable
import javax.inject.Inject

class CheckHistoryUseCase @Inject constructor(private val repositorySingleTable: RepositorySingleTable) {
    operator fun invoke(keyStorage: String): Boolean {
        return repositorySingleTable.checkHistory(keyStorage = keyStorage)
    }
}