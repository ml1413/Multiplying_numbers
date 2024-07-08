package com.multiplying_numbers.domain.repository

import com.multiplying_numbers.domain.models.ModelQuestions

interface RepositoryListTables {
    fun getListTables(): List<List<ModelQuestions>>
}