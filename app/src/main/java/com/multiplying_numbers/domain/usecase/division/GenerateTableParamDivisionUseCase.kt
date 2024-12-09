package com.multiplying_numbers.domain.usecase.division

import com.multiplying_numbers.domain.TypeTable
import com.multiplying_numbers.domain.models.TableParams
import com.multiplying_numbers.domain.repository.RepositoryListTablesDivision
import javax.inject.Inject

class GenerateTableParamDivisionUseCase @Inject constructor(private val repositoryListTablesDivision: RepositoryListTablesDivision) {
    operator fun invoke(idTable: Int) : TableParams {
      return  repositoryListTablesDivision.generateTableParamDivision(idTable=idTable)
    }
}