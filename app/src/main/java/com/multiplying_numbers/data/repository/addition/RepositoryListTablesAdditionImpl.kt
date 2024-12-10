package com.multiplying_numbers.data.repository.addition

import com.multiplying_numbers.data.addition.GetStartedListTablesAddition
import com.multiplying_numbers.domain.models.ModelTabForCard
import com.multiplying_numbers.domain.repository.RepositoryListTablesAddition
import javax.inject.Inject

class RepositoryListTablesAdditionImpl @Inject constructor(
    private val getStartedListTablesAddition: GetStartedListTablesAddition
):RepositoryListTablesAddition {
    override fun getListTablesAddition(): List<ModelTabForCard> {
     return  getStartedListTablesAddition.getListTablesAddition()
    }
}