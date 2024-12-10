package com.multiplying_numbers.presentation.fragments.list_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.multiplying_numbers.domain.models.ModelTabForCard
import com.multiplying_numbers.domain.usecase.addition.GetListTableAdditionUseCase
import com.multiplying_numbers.domain.usecase.division.GetListTableDivisionUseCase
import com.multiplying_numbers.domain.usecase.multiple.GetListTablesMultipleUseCase
import com.multiplying_numbers.domain.usecase.subtraction.GetListTablesSubtractionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListTablesViewModel @Inject constructor(
    private val getListTablesMultipleUseCase: GetListTablesMultipleUseCase,
    private val getListTableDivisionUseCase: GetListTableDivisionUseCase,
    private val getListTableAdditionUseCase: GetListTableAdditionUseCase,
    private val getListTablesSubtractionUseCase: GetListTablesSubtractionUseCase
) : ViewModel() {
    private val _listsTables = MutableLiveData<StateLists>(StateLists.Initial)
    val listsTables: LiveData<StateLists> = _listsTables

    fun getListMultiple() {
        val listsTables = getListTablesMultipleUseCase()
        _listsTables.value = StateLists.ListTables(listsTables = listsTables)
    }


    fun getListDivision() {
        val listsTables = getListTableDivisionUseCase()
        _listsTables.value = StateLists.ListTables(listsTables = listsTables)
    }

    fun getListAddition() {
        val listsTables = getListTableAdditionUseCase()
        _listsTables.value = StateLists.ListTables(listsTables = listsTables)

    }

    fun getListSubtraction() {
        val listsTables = getListTablesSubtractionUseCase()
        _listsTables.value = StateLists.ListTables(listsTables = listsTables)
    }


    sealed class StateLists {
        object Initial : StateLists()
        class ListTables(val listsTables: List<ModelTabForCard>) : StateLists()
    }
}