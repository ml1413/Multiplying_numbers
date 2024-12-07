package com.multiplying_numbers.domain.multiple.usecase

import com.multiplying_numbers.domain.multiple.models.TableParams
import com.multiplying_numbers.domain.multiple.repository.RepositoryListTables
import javax.inject.Inject

class GenerateTableParamMultipleUseCase @Inject constructor(
private val repositoryListTables: RepositoryListTables
) {
    operator fun invoke(idTable: Int) :TableParams{
       return repositoryListTables.generateTableParams(idTable=idTable)
    }
}