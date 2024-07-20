package com.multiplying_numbers.presentation.fragment.list_fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.multiplying_numbers.data.repository.RepositoryListTablesImpl
import com.multiplying_numbers.data.storage.GetListTablesImpl
import com.multiplying_numbers.domain.usecase.GetListTablesUseCase

class ListTablesViewModelFactory() : ViewModelProvider.Factory {
    private val getListTables = GetListTablesImpl()
    private val repositoryListTables = RepositoryListTablesImpl(getListTables = getListTables)
    private val getListTablesUseCase =
        GetListTablesUseCase(repositoryListTables = repositoryListTables)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ListTablesViewModel(getListTablesUseCase = getListTablesUseCase) as T
    }

}