package com.multiplying_numbers.domain.multiple.usecase

import com.multiplying_numbers.domain.multiple.models.ModelSingleTab
import com.multiplying_numbers.domain.multiple.models.TableParams
import com.multiplying_numbers.domain.multiple.repository.RepositorySingleTable
import javax.inject.Inject

class GetSingleTableUseCase @Inject constructor(
    private val repositorySingleTable: RepositorySingleTable
) {
    operator fun invoke(tableParams: TableParams): ModelSingleTab {
        return repositorySingleTable.getTable(tableParams = tableParams)
    }
}