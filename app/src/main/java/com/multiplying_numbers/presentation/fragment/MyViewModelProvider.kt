package com.multiplying_numbers.presentation.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.multiplying_numbers.data.repository.RepositoryListTablesImpl
import com.multiplying_numbers.data.storage.GetListTablesImpl
import com.multiplying_numbers.domain.usecase.GetListTablesUseCase
import com.multiplying_numbers.presentation.fragment.list_fragment.ListTablesViewModel
import com.multiplying_numbers.presentation.fragment.table_fragment.SingleTableViewModel

class MyViewModelProvider(
    private val viewModel : ViewModelsFactory
) : ViewModelProvider.Factory {
    private val getListTables = GetListTablesImpl()
    private val repositoryListTables = RepositoryListTablesImpl(getListTables = getListTables)
    private val getListTablesUseCase =
        GetListTablesUseCase(repositoryListTables = repositoryListTables)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return   when (viewModel) {
            ViewModelsFactory.ListTablesViewModel -> {
                ListTablesViewModel(getListTablesUseCase = getListTablesUseCase) as T
            }
            ViewModelsFactory.SingleTableViewModel ->{
                SingleTableViewModel(getListTablesUseCase = getListTablesUseCase) as T
            }
        }

    }
    sealed class ViewModelsFactory{
        object ListTablesViewModel : ViewModelsFactory()
        object SingleTableViewModel: ViewModelsFactory()
    }
}