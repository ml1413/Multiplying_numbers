package com.multiplying_numbers.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.multiplying_numbers.data.repository.RepositoryListQuestionsImpl
import com.multiplying_numbers.data.storage.GetListStorageImpl
import com.multiplying_numbers.domain.usecase.GetListQuestionsUseCase

class ViewModelQuestionsFactory : ViewModelProvider.Factory {
    private val storage
            by lazy { GetListStorageImpl() }

    private val repository
            by lazy { RepositoryListQuestionsImpl(storage = storage) }

    private val getListQuestionsUseCase
            by lazy { GetListQuestionsUseCase(repository = repository) }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return ViewModelQuestions(getListQuestionsUseCase = getListQuestionsUseCase) as T
    }
}