package com.multiplying_numbers.presentation.fragment.single_table_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.multiplying_numbers.domain.models.ModelQuestions

class CountWrongAnswerViewModel : ViewModel() {
    private val _countWrongAnswer = MutableLiveData<StateWrongAnswer>(StateWrongAnswer.Initial)
    val countWrongAnswer: LiveData<StateWrongAnswer> = _countWrongAnswer
    fun setCountWrongAnswer(listTable: List<ModelQuestions>) {
        val count = listTable.count { it.isCorrect == false }
        val state = _countWrongAnswer.value
        if (state == StateWrongAnswer.Initial) {
            _countWrongAnswer.value = StateWrongAnswer.WrongAnswerResult(count = count)
        }

        if (state is StateWrongAnswer.WrongAnswerResult) {
            if (count > state.count) {
                _countWrongAnswer.value = StateWrongAnswer.WrongAnswerResult(count = count)
            }
        }
    }

    sealed class StateWrongAnswer {
        object Initial : StateWrongAnswer()
        class WrongAnswerResult(val count: Int) : StateWrongAnswer()
    }
}