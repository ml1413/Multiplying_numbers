package com.multiplying_numbers.domain.repository

import com.multiplying_numbers.domain.models.ModelQuestions

interface Repository {
    fun getListQuestions(modelQuestions: ModelQuestions): List<ModelQuestions>
}