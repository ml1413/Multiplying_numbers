package com.multiplying_numbers.data.repository.division

import com.multiplying_numbers.data.division.GetStartedListTablesDivision
import com.multiplying_numbers.domain.models.ModelTabForCard
import com.multiplying_numbers.domain.models.TableParams
import com.multiplying_numbers.domain.repository.RepositoryListTablesDivision
import javax.inject.Inject

class RepositoryListTablesDivisionImpl @Inject constructor(private val getStartedListTablesDivision: GetStartedListTablesDivision) :
    RepositoryListTablesDivision {
    override fun getListTablesDivision(): List<ModelTabForCard> {
        return getStartedListTablesDivision.getListTablesDivision()
    }

    override fun generateTableParamDivision(idTable: Int): TableParams {
        return getStartedListTablesDivision.generateTableParamDivision(idTable = idTable)
    }
}