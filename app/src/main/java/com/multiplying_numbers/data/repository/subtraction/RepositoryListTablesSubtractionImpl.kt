package com.multiplying_numbers.data.repository.subtraction

import com.multiplying_numbers.data.subtraction.GetStartedListTablesSubtraction
import com.multiplying_numbers.domain.models.ModelTabForCard
import com.multiplying_numbers.domain.repository.RepositoryListTablesSubtraction
import javax.inject.Inject

class RepositoryListTablesSubtractionImpl @Inject constructor(
    private val getStartedListTablesSubtraction: GetStartedListTablesSubtraction
) : RepositoryListTablesSubtraction {
    override fun getListTablesSubtraction(): List<ModelTabForCard> {
        return getStartedListTablesSubtraction.getListTablesSubtraction()
    }
}