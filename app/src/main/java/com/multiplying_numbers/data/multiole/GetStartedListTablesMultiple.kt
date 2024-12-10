package com.multiplying_numbers.data.multiole

import com.multiplying_numbers.domain.models.ModelTabForCard
import com.multiplying_numbers.domain.models.TableParams

interface GetStartedListTablesMultiple {
    fun getListTables(): List<ModelTabForCard>
}