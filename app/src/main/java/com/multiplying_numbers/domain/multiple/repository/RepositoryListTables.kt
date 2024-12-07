package com.multiplying_numbers.domain.multiple.repository

import com.multiplying_numbers.domain.multiple.models.ModelTabForCard
import com.multiplying_numbers.domain.multiple.models.TableParams


interface RepositoryListTables {
    fun getListTables(): List<ModelTabForCard>
    fun generateTableParams(idTable: Int): TableParams
}