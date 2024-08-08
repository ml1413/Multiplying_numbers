package com.multiplying_numbers.presentation.fragment.single_table_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.multiplying_numbers.domain.models.ModelItemVictory
import com.multiplying_numbers.domain.models.ModelParameterForSave
import com.multiplying_numbers.domain.models.ModelQuestions
import com.multiplying_numbers.domain.usecase.GetListResultUseCase
import com.multiplying_numbers.domain.usecase.GetListTablesUseCase
import com.multiplying_numbers.domain.usecase.SaveListResultUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SingleTableViewModel @Inject constructor(
    private val getListTablesUseCase: GetListTablesUseCase,
    private val saveListResultUseCase: SaveListResultUseCase,
    private val getListResultUseCase: GetListResultUseCase
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

    fun showResult(index: Int) {

        val state = _singleList.value
        if (state is SingleTabState.SingleStateResult) {
            // get list from view model
            val listFromViewModel = state.list
            //create item for recycler view
            val modelItemVictory = ModelItemVictory(
                keyNameTable = index.toString(),
                date = System.currentTimeMillis(),
                hasWrongAnswer = listFromViewModel.sumOf { it.countWrongAnswer } > 0,
                listAnswer = listFromViewModel)
            // get old list from storage
            val modelParameter = getListResultFromStorage(index = index)

            if (modelParameter != null) {
                // if list is exist add to old list new item
                val newList = modelParameter.listModelItemVictory.toMutableList()
                newList.add(modelItemVictory)
                newList.toList()
                //create model for save in storage
                val modelParameterForSave = ModelParameterForSave(listModelItemVictory = newList)
                // save list in storage
                saveListResultUseCase(
                    modelParameterForSave = modelParameterForSave,
                    keyName = index.toString()
                )
            } else {
                // if list from storage not exist  create model for save in storage
                val modelParameterForSave =
                    ModelParameterForSave(listModelItemVictory = listOf(modelItemVictory))
                // save first item  in storage
                saveListResultUseCase(
                    modelParameterForSave = modelParameterForSave,
                    keyName = index.toString()
                )
            }
            // set value in view model
            _singleList.value = SingleTabState.ShowResult
        }

    }

    fun getListResultFromStorage(index: Int) =
        getListResultUseCase(keyName = index.toString())


    sealed class SingleTabState {
        object Initial : SingleTabState()
        class SingleStateResult(val list: List<ModelQuestions>) : SingleTabState()
        object ShowResult : SingleTabState()
        object Loading : SingleTabState()
    }
}