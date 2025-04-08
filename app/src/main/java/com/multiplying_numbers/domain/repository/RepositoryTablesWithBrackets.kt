package com.multiplying_numbers.domain.repository

import com.multiplying_numbers.domain.models.ModelTabForCard

interface RepositoryTablesWithBrackets {
    fun getListTables(): List<ModelTabForCard>
}