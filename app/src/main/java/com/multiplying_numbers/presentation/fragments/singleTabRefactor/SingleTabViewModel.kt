package com.multiplying_numbers.presentation.fragments.singleTabRefactor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.multiplying_numbers.domain.models.ModelSingleTab
import com.multiplying_numbers.domain.models.TableParams
import com.multiplying_numbers.domain.usecase.game_usecase.CheckLeftAnswerUseCase
import com.multiplying_numbers.domain.usecase.game_usecase.CheckRightAnswerUseCase
import com.multiplying_numbers.domain.usecase.game_usecase.GetSingleTableUseCase
import com.multiplying_numbers.domain.usecase.game_usecase.SaveInStorageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "SingleTabViewModelREFACTOR"

@HiltViewModel
class SingleTabViewModel @Inject constructor(
    private val getSingleTableUseCase: GetSingleTableUseCase,
    private val checkLeftAnswerUseCase: CheckLeftAnswerUseCase,
    private val checkRightAnswerUseCase: CheckRightAnswerUseCase,
    private val saveInStorageUseCase: SaveInStorageUseCase,
) : ViewModel() {

    private val _table = MutableLiveData<StateTable>(StateTable.Initial)
    val table: LiveData<StateTable> = _table

    fun getTable(tableParams: TableParams) {
        val modelSingleTab = getSingleTableUseCase.invoke(tableParams = tableParams)
        _table.value = StateTable.ResumeGame(modelSingleTab = modelSingleTab)
    }

    fun checkLeftAnswer() {
        _table.value?.checkState(
            onResumeGame = { oldModelSingleTab ->
                val newModel =
                    checkLeftAnswerUseCase(modelSingleTab = oldModelSingleTab)
                checkAnswer(newModel)
            }
        )
    }

    fun checkRightAnswer() {
        _table.value?.checkState(
            onResumeGame = { oldModelSingleTab ->
                val newModel =
                    checkRightAnswerUseCase(modelSingleTab = oldModelSingleTab)
                checkAnswer(newModel)
            }
        )
    }

    fun saveInStorage() {
        _table.value?.checkState(onVictory = { modelItemTab ->
            saveInStorageUseCase(modelSingleTab = modelItemTab)
        })
    }




    sealed class StateTable() {
        object Initial : StateTable()
        object DisableButton : StateTable()
        class ResumeGame(val modelSingleTab: ModelSingleTab) : StateTable()
        class Victory(val modelSingleTab: ModelSingleTab) : StateTable()
    }

    /** otherFun__________________________________________________________________________________*/

    private fun StateTable.checkState(
        onInitial: () -> Unit = {},
        onResumeGame: (ModelSingleTab) -> Unit = {},
        onVictory: (ModelSingleTab) -> Unit = {},
        onDisableButton: () -> Unit = {}
    ) {
        when (this) {
            StateTable.Initial -> onInitial()
            is StateTable.ResumeGame -> onResumeGame(modelSingleTab)
            is StateTable.Victory -> onVictory(modelSingleTab)
            StateTable.DisableButton -> onDisableButton()
        }
    }

    private fun checkAnswer(newModel: ModelSingleTab) {
        _table.value = StateTable.ResumeGame(modelSingleTab = newModel)
        checkVictory()
    }

    private fun checkVictory() {
        _table.value?.checkState(
            onResumeGame = { modelItemTab ->
                if (modelItemTab.isAllAnswerCorrect) {
                    viewModelScope.launch {
                        _table.value = StateTable.DisableButton
                        delay(1000)
                        _table.value = StateTable.Victory(modelSingleTab = modelItemTab)
                    }
                }
            })
    }


}