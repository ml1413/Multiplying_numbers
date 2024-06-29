package com.multiplying_numbers.data.storage

import com.multiplying_numbers.domain.models.ModelQuestions

interface Storage {
    fun getListQuestions(modelQuestions: ModelQuestions): List<ModelQuestions>
}