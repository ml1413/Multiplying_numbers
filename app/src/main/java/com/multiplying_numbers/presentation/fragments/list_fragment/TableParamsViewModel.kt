package com.multiplying_numbers.presentation.fragments.list_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.multiplying_numbers.domain.models.TableParams
import com.multiplying_numbers.domain.usecase.division.GenerateTableParamDivisionUseCase
import com.multiplying_numbers.domain.usecase.multiple.GenerateTableParamMultipleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TableParamsViewModel @Inject constructor(
    private val generateTableParamMultipleUseCase: GenerateTableParamMultipleUseCase,
    private val generateTableParamDivisionUseCase: GenerateTableParamDivisionUseCase,
) : ViewModel() {
    private val _tableState = MutableLiveData<TableState>(TableState.Initial)
    val tableState: LiveData<TableState> = _tableState
    fun generateTableParamDivision(idTable: Int) {
        val tableParams = generateTableParamDivisionUseCase(idTable = idTable)
        _tableState.value = TableState.ParamsForOpenSingleTable(tableParams = tableParams)
    }

    fun generateTableParamMultiple(idTable: Int) {
        val tableParams = generateTableParamMultipleUseCase(idTable = idTable)
        _tableState.value = TableState.ParamsForOpenSingleTable(tableParams = tableParams)
    }

    fun setInitial() {
        _tableState.value = TableState.Initial
    }

    sealed class TableState() {
        object Initial : TableState()
        class ParamsForOpenSingleTable(val tableParams: TableParams) : TableState()
    }

}