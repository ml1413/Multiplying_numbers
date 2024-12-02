package com.multiplying_numbers.domain.multiple.repository

import com.multiplying_numbers.domain.multiple.models.ModelTabForCard


interface RepositoryListTables {
    fun getListTables(): List<ModelTabForCard>
}