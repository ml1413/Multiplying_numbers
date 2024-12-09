package com.multiplying_numbers.domain.usecase

import com.multiplying_numbers.domain.repository.RepositorySingleTable
import javax.inject.Inject

class CheckHistoryUseCase @Inject constructor(private val repositorySingleTable: RepositorySingleTable) {
    operator fun invoke(keyStorage: String): Boolean {
        return repositorySingleTable.checkHistory(keyStorage = keyStorage)
    }
}