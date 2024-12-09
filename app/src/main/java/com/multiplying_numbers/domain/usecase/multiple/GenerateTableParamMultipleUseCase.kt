package com.multiplying_numbers.domain.usecase.multiple

import com.multiplying_numbers.domain.models.TableParams
import com.multiplying_numbers.domain.repository.multiple.RepositoryListTables
import javax.inject.Inject

class GenerateTableParamMultipleUseCase @Inject constructor(
private val repositoryListTables: RepositoryListTables
) {
    operator fun invoke(idTable: Int) : TableParams {
       return repositoryListTables.generateTableParams(idTable=idTable)
    }
}