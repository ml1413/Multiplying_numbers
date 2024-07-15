package com.multiplying_numbers.presentation.fragment.vistory_fragment

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.multiplying_numbers.data.repository.RepositoryListResultImpl
import com.multiplying_numbers.data.storage.StorageListResultSharedImpl
import com.multiplying_numbers.domain.usecase.GetListResultUseCase
import com.multiplying_numbers.domain.usecase.SaveListResultUseCase

class ListResultViewModelFactory(val context: Context) : ViewModelProvider.Factory {
    private val storageListResultImpl =
        StorageListResultSharedImpl(context = context)
    private val repositoryListResultImpl =
        RepositoryListResultImpl(storageListResult = storageListResultImpl)
    private val saveUseCase =
        SaveListResultUseCase(repositoryListResult = repositoryListResultImpl)
    private val getListResultUseCase = GetListResultUseCase(repositoryListResult = repositoryListResultImpl)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ListResultViewModel(saveUseCase = saveUseCase,
            getListResultUseCase = getListResultUseCase
            ) as T
    }

}