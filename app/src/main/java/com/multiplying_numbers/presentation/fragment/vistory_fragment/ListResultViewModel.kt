package com.multiplying_numbers.presentation.fragment.vistory_fragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.multiplying_numbers.domain.models.ModelLabelResultAnswer
import com.multiplying_numbers.domain.models.ModelQuestions
import com.multiplying_numbers.domain.models.ModelWrapper
import com.multiplying_numbers.domain.usecase.GetListResultUseCase
import com.multiplying_numbers.domain.usecase.SaveListResultUseCase

class ListResultViewModel(
    private val saveUseCase: SaveListResultUseCase,
    private val getListResultUseCase: GetListResultUseCase
) : ViewModel() {
    private val _listResult = MutableLiveData<StateListResult>(StateListResult.Initial)
    val listResult: LiveData<StateListResult> = _listResult

    fun setResult(listResult: List<ModelWrapper>, keyName: String) {
        val listFromStorage = getListResultUseCase.invoke(keyName = keyName)
        if (listFromStorage != null) {
            val newList = listFromStorage.toMutableList()
            newList.addAll(listResult)
            newList.toList()
            _listResult.value = StateListResult.Result(listResult = newList)
        } else {
            _listResult.value = StateListResult.Result(listResult = listResult)
        }
    }


    fun saveListInStorage(keyName: String) {
        val state = _listResult.value
        if (state is StateListResult.Result) {
            val list = state.listResult
            saveUseCase.invoke(listResult = list, keyName = keyName)
        }
    }


    sealed class StateListResult {
        object Initial : StateListResult()
        class Result(val listResult: List<ModelWrapper>) : StateListResult()
    }

}