package com.multiplying_numbers.domain.usecase.multiple

import com.multiplying_numbers.domain.models.TableParams
import com.multiplying_numbers.domain.repository.RepositoryListTablesMultiple
import javax.inject.Inject

class GenerateTableParamMultipleUseCase @Inject constructor(
private val repositoryListTablesMultiple: RepositoryListTablesMultiple
) {
    operator fun invoke(idTable: Int) : TableParams {
       return repositoryListTablesMultiple.generateTableParamsMultiple(idTable=idTable)
    }
}