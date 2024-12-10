package com.multiplying_numbers.domain.repository

import com.multiplying_numbers.domain.models.ModelTabForCard
import com.multiplying_numbers.domain.models.TableParams

interface RepositoryListTablesDivision {
    fun getListTablesDivision(): List<ModelTabForCard>
}