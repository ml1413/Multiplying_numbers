package com.multiplying_numbers.domain.repository.multiple

import com.multiplying_numbers.domain.models.multiple.ModelTabForCard
import com.multiplying_numbers.domain.models.TableParams


interface RepositoryListTables {
    fun getListTables(): List<ModelTabForCard>
    fun generateTableParams(idTable: Int): TableParams
}