package com.multiplying_numbers.domain.multiple.usecase

import com.multiplying_numbers.domain.multiple.models.ModelItemTab
import com.multiplying_numbers.domain.multiple.repository.RepositorySingleTable
import javax.inject.Inject

class GetSingleTableUseCase @Inject constructor(
    private val repositorySingleTable: RepositorySingleTable
) {
    operator fun invoke(idTable: Int): ModelItemTab {
        return repositorySingleTable.getTable(idTable = idTable)
    }
}