package com.multiplying_numbers.presentation.fragment.vistory_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.multiplying_numbers.domain.models.ModelItemVictory
import com.multiplying_numbers.domain.usecase.GetListResultUseCase
import com.multiplying_numbers.domain.usecase.SaveListResultUseCase

class ListResultViewModel(
    private val saveUseCase: SaveListResultUseCase,
    private val getListResultUseCase: GetListResultUseCase,
    private val index: Int
) : ViewModel() {
    private val _listResult = MutableLiveData<StateListResult>(StateListResult.Initial)
    val listResult: LiveData<StateListResult> = _listResult

    init {
        val modelParameterForSave = getListResultUseCase(keyName = index.toString())
        if (modelParameterForSave != null) {
            val list = modelParameterForSave.listModelItemVictory
            _listResult.value = StateListResult.Result(listResult = list)
        }
        super.onCleared()
    }

    sealed class StateListResult {
        object Initial : StateListResult()
        class Result(val listResult: List<ModelItemVictory>) : StateListResult()
    }

}