package com.multiplying_numbers.data.storage

import com.multiplying_numbers.domain.models.ModelTabForCard

interface GetListTables {
    fun getListTables(): List<ModelTabForCard>
}