package com.multiplying_numbers.domain.usecase

import com.multiplying_numbers.domain.models.ModelItemTab
import com.multiplying_numbers.domain.repository.RepositorySingleTable
import javax.inject.Inject

class GetSingleTableUseCase @Inject constructor(
    private val repositorySingleTable: RepositorySingleTable
) {
    operator fun invoke(idTable: Int): ModelItemTab {
        return repositorySingleTable.getTable(idTable = idTable)
    }
}