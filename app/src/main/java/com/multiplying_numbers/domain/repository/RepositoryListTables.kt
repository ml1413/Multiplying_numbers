package com.multiplying_numbers.domain.repository

import com.multiplying_numbers.domain.models.ModelTabForCard


interface RepositoryListTables {
    fun getListTables(): List<ModelTabForCard>
}