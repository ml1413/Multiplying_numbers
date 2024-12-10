package com.multiplying_numbers.domain.repository

import com.multiplying_numbers.domain.models.ModelTabForCard

interface RepositoryListTablesAddition {
    fun getListTablesAddition(): List<ModelTabForCard>
}