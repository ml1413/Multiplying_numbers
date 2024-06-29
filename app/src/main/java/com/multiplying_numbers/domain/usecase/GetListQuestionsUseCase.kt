package com.multiplying_numbers.domain.usecase

import com.multiplying_numbers.domain.models.ModelQuestions
import com.multiplying_numbers.domain.repository.Repository

class GetListQuestionsUseCase(
    private val repository: Repository
) {
    operator fun invoke(modelQuestions: ModelQuestions): List<ModelQuestions> {
        val list = repository.getListQuestions(modelQuestions = modelQuestions)
        return list
    }
}