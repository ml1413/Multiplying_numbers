package com.multiplying_numbers.presentation.fragment.single_table_fragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.multiplying_numbers.domain.models.ModelQuestions
import com.multiplying_numbers.domain.usecase.GetListTablesUseCase

class SingleTableViewModel(
    private val getListTablesUseCase: GetListTablesUseCase
) : ViewModel() {
    private val _singleList = MutableLiveData<SingleTabState>(SingleTabState.Initial)
    val singleList: LiveData<SingleTabState> = _singleList

    fun setList(index: Int) {
        val list = getListTablesUseCase()[index]
        _singleList.value = SingleTabState.SingleStateResult(list = list)
    }

    fun setAnswerInTableList(modelQuestions: ModelQuestions) {
        val state = _singleList.value
        if (state is SingleTabState.SingleStateResult) {
            val newList = state.list.toMutableList()
                .map {
                    if (it.id == modelQuestions.id)
                        modelQuestions
                    else
                        it
                }.toList()
            _singleList.value = SingleTabState.SingleStateResult(list = newList)
        }

    }


    sealed class SingleTabState {
        object Initial : SingleTabState()
        class SingleStateResult(val list: List<ModelQuestions>) : SingleTabState()
        object Loading : SingleTabState()
    }
}