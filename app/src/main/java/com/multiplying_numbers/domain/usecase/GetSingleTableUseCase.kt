package com.multiplying_numbers.domain.usecase

import com.multiplying_numbers.domain.models.ModelSingleTab
import com.multiplying_numbers.domain.models.TableParams
import com.multiplying_numbers.domain.repository.RepositorySingleTable
import javax.inject.Inject

class GetSingleTableUseCase @Inject constructor(
    private val repositorySingleTable: RepositorySingleTable
) {
    operator fun invoke(tableParams: TableParams): ModelSingleTab {
        return repositorySingleTable.getTable(tableParams = tableParams)
    }
}