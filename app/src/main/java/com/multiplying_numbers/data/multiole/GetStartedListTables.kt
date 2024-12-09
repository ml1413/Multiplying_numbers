package com.multiplying_numbers.data.multiole

import com.multiplying_numbers.domain.models.multiple.ModelTabForCard
import com.multiplying_numbers.domain.models.TableParams

interface GetStartedListTables {
    fun getListTables(): List<ModelTabForCard>
    fun generateTableParams(idTable: Int): TableParams
}