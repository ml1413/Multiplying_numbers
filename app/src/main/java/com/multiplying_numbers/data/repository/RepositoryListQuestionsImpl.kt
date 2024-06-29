package com.multiplying_numbers.data.repository

import com.multiplying_numbers.data.storage.Storage
import com.multiplying_numbers.domain.repository.Repository
import com.multiplying_numbers.domain.models.ModelQuestions
import com.multiplying_numbers.domain.usecase.GetListQuestionsUseCase

class RepositoryListQuestionsImpl(
    private val storage: Storage
) : Repository {
    override fun getListQuestions(modelQuestions: ModelQuestions): List<ModelQuestions> {
        val list = storage.getListQuestions(modelQuestions = modelQuestions)
        return list
    }
}