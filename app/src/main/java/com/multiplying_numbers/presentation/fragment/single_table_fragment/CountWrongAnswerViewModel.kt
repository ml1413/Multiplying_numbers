package com.multiplying_numbers.presentation.fragment.single_table_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.multiplying_numbers.domain.models.ModelQuestions

class CountWrongAnswerViewModel : ViewModel() {
    private val _countWrongAnswer = MutableLiveData<StateWrongAnswer>(StateWrongAnswer.Initial)
    val countWrongAnswer: LiveData<StateWrongAnswer> = _countWrongAnswer

    init {
        _countWrongAnswer.value = StateWrongAnswer.WrongAnswerResult(listTable = emptyList())
    }

    fun setCountWrongAnswer(listTable: List<ModelQuestions>) {
        val newList = listTable.filter { it.isCorrect == false }
        val state = _countWrongAnswer.value
        if (state is StateWrongAnswer.WrongAnswerResult) {
            val oldList = state.listTable
            if (newList.count() > oldList.count()) {
                _countWrongAnswer.value = StateWrongAnswer.WrongAnswerResult(listTable = newList)
            }
        }

    }

    sealed class StateWrongAnswer {
        object Initial : StateWrongAnswer()
        class WrongAnswerResult(val listTable: List<ModelQuestions>) : StateWrongAnswer()
    }
}