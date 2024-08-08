package com.multiplying_numbers.presentation.fragment.vistory_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.multiplying_numbers.domain.models.ModelItemVictory
import com.multiplying_numbers.domain.usecase.GetListResultUseCase
import com.multiplying_numbers.domain.usecase.SaveListResultUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListResultViewModel @Inject constructor(
    private val getListResultUseCase: GetListResultUseCase,
) : ViewModel() {
    private val _listResult = MutableLiveData<StateListResult>(StateListResult.Initial)
    val listResult: LiveData<StateListResult> = _listResult

    fun initValueInViewModel(index:Int) {
        val modelParameterForSave = getListResultUseCase(keyName = index.toString())
        if (modelParameterForSave != null) {
            val list = modelParameterForSave.listModelItemVictory
            _listResult.value = StateListResult.Result(listResult = list)
        }
    }

    sealed class StateListResult {
        object Initial : StateListResult()
        class Result(val listResult: List<ModelItemVictory>) : StateListResult()
    }

}