package com.multiplying_numbers.presentation.fragment.single_table_fragment

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.multiplying_numbers.data.repository.RepositoryListResultImpl
import com.multiplying_numbers.data.repository.RepositoryListTablesImpl
import com.multiplying_numbers.data.storage.GetListTablesImpl
import com.multiplying_numbers.data.storage.StorageListResultSharedImpl
import com.multiplying_numbers.domain.usecase.GetListResultUseCase
import com.multiplying_numbers.domain.usecase.GetListTablesUseCase
import com.multiplying_numbers.domain.usecase.SaveListResultUseCase
import com.multiplying_numbers.presentation.fragment.list_fragment.ListTablesViewModel

class SingleTabViewModelFactory(context: Context) : ViewModelProvider.Factory {
    private val getListTables = GetListTablesImpl()
    private val repositoryListTables = RepositoryListTablesImpl(getListTables = getListTables)
    private val getListTablesUseCase =
        GetListTablesUseCase(repositoryListTables = repositoryListTables)
    private val storageListResultImpl =
        StorageListResultSharedImpl(context = context)
    private val repositoryListResultImpl =
        RepositoryListResultImpl(storageListResult = storageListResultImpl)
    private val saveUseCase =
        SaveListResultUseCase(repositoryListResult = repositoryListResultImpl)
    private val getListResultUseCase =
        GetListResultUseCase(repositoryListResult = repositoryListResultImpl)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SingleTableViewModel(
            getListTablesUseCase = getListTablesUseCase,
            saveListResultUseCase = saveUseCase,
            getListResultUseCase = getListResultUseCase
        ) as T
    }

}