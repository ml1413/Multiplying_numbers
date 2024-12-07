package com.multiplying_numbers.data.multiple

import com.multiplying_numbers.domain.multiple.models.ModelTabForCard
import com.multiplying_numbers.domain.multiple.models.TableParams

interface GetStartedListTables {
    fun getListTables(): List<ModelTabForCard>
    fun generateTableParams(idTable: Int): TableParams
}