package com.multiplying_numbers.presentation.fragment.vistory_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.multiplying_numbers.domain.models.ModelItemVictory
import com.multiplying_numbers.domain.models.ModelParameterForSave
import com.multiplying_numbers.domain.usecase.GetListResultUseCase
import com.multiplying_numbers.domain.usecase.SaveListResultUseCase

class ListResultViewModel(
    private val saveUseCase: SaveListResultUseCase,
    private val getListResultUseCase: GetListResultUseCase
) : ViewModel() {
    private val _listResult = MutableLiveData<StateListResult>(StateListResult.Initial)
    val listResult: LiveData<StateListResult> = _listResult

    fun setResult(modelItemResult: ModelItemVictory, keyName: String) {

        val modelParameterForSave = getListResultUseCase.invoke(keyName = keyName)
        val listResult = modelParameterForSave?.listModelItemVictory
        if (listResult != null) {
            val newList = listResult.toMutableList()
            newList.add(modelItemResult)
            newList.toList()
            _listResult.value = StateListResult.Result(listResult = newList)
        } else {
            _listResult.value = StateListResult.Result(listResult = listOf(modelItemResult))
        }

    }


    fun saveListInStorage(keyName: String) {

        val state = _listResult.value
        if (state is StateListResult.Result) {

            val modelParameterForSave = ModelParameterForSave(
                listModelItemVictory = state.listResult
            )

            saveUseCase.invoke(modelParameterForSave = modelParameterForSave, keyName = keyName)
        }
    }


    sealed class StateListResult {
        object Initial : StateListResult()
        class Result(val listResult: List<ModelItemVictory>) : StateListResult()
    }

}