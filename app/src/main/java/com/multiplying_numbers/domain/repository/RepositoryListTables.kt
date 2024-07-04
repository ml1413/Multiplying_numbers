package com.multiplying_numbers.domain.repository

import com.multiplying_numbers.domain.models.ModelQuestions2

interface RepositoryListTables {
    fun getListTables(): List<List<ModelQuestions2>>
}