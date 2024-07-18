package com.multiplying_numbers.presentation.fragment.single_table_fragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.multiplying_numbers.domain.models.ModelQuestions

class CountWrongAnswerViewModel : ViewModel() {
    private val _countWrongAnswer = MutableLiveData<StateWrongAnswer>(StateWrongAnswer.Initial)
    val countWrongAnswer: LiveData<StateWrongAnswer> = _countWrongAnswer

    init {
        _countWrongAnswer.value = StateWrongAnswer.WrongAnswerResult(listResultAnswer = emptyList())
    }

    fun setCountWrongAnswer(listTable: List<ModelQuestions>) {
//        val newList = listTable.filter { it.countWrongAnswer > 0 }
        val state = _countWrongAnswer.value
        if (state is StateWrongAnswer.WrongAnswerResult) {
            val oldList = state.listResultAnswer
            if (listTable.sumOf { it.countWrongAnswer } > oldList.sumOf { it.countWrongAnswer }) {
                _countWrongAnswer.value =
                    StateWrongAnswer.WrongAnswerResult(listResultAnswer = listTable)
            }

        }


    }

    fun showResultAnswer() {
        val state = _countWrongAnswer.value
        if (state is StateWrongAnswer.WrongAnswerResult) {
            val list = state.listResultAnswer
            _countWrongAnswer.value = StateWrongAnswer.ResultVictory(listResultAnswer = list)
        }

    }

    sealed class StateWrongAnswer {
        object Initial : StateWrongAnswer()
        class WrongAnswerResult(val listResultAnswer: List<ModelQuestions>) : StateWrongAnswer()
        class ResultVictory(val listResultAnswer: List<ModelQuestions>) : StateWrongAnswer()
    }
}