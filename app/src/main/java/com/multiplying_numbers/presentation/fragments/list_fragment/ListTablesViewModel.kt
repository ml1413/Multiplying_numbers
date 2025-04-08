package com.multiplying_numbers.presentation.fragments.list_fragment

import android.util.Printer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.multiplying_numbers.domain.models.ModelTabForCard
import com.multiplying_numbers.domain.usecase.table_usecase.addition.GetListTableAdditionUseCase
import com.multiplying_numbers.domain.usecase.table_usecase.division.GetListTableDivisionUseCase
import com.multiplying_numbers.domain.usecase.table_usecase.multiple.GetListTablesMultipleUseCase
import com.multiplying_numbers.domain.usecase.table_usecase.subtraction.GetListTablesSubtractionUseCase
import com.multiplying_numbers.domain.usecase.table_usecase.with_brackets.GetListTablesWithBracketsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import java.security.PrivateKey
import javax.inject.Inject

@HiltViewModel
class ListTablesViewModel @Inject constructor(
    private val getListTablesMultipleUseCase: GetListTablesMultipleUseCase,
    private val getListTableDivisionUseCase: GetListTableDivisionUseCase,
    private val getListTableAdditionUseCase: GetListTableAdditionUseCase,
    private val getListTablesSubtractionUseCase: GetListTablesSubtractionUseCase,
    private val getListTablesWithBracketsUseCase: GetListTablesWithBracketsUseCase
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

    fun getListWithBrackets() {
        val listTables = getListTablesWithBracketsUseCase()
        _listsTables.value = StateLists.ListTables(listsTables = listTables)
    }


    sealed class StateLists {
        object Initial : StateLists()
        class ListTables(val listsTables: List<ModelTabForCard>) : StateLists()
    }
}