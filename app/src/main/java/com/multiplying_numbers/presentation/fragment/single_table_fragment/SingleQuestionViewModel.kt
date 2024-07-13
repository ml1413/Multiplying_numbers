package com.multiplying_numbers.presentation.fragment.single_table_fragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.multiplying_numbers.domain.models.ModelQuestions


class SingleQuestionViewModel : ViewModel() {

    private val _singleQuestion = MutableLiveData<SingleQuestionState>(SingleQuestionState.Initial)
    val singleQuestion: LiveData<SingleQuestionState> = _singleQuestion

    fun setSingleQuestion(listModels: List<ModelQuestions>) {

        if (_singleQuestion.value == SingleQuestionState.Initial) {
            val singleQuestion = listModels.filter {
                it.isCorrect == null || !it.isCorrect
            }

            if (singleQuestion.isNotEmpty()) {
                val randomModel = singleQuestion.random()
                _singleQuestion.value =
                    SingleQuestionState.Result(modelQuestions = randomModel)
            } else {
                _singleQuestion.value = SingleQuestionState.Victory
            }
        }
    }

    fun checkAnswer(answerValue: Int) {
        val state = _singleQuestion.value
        if (state is SingleQuestionState.Result) {
            val oldModel = state.modelQuestions
            val isCorrectAnswer = oldModel.correctAnswer == answerValue
            val countWrongAnswer =
                if (!isCorrectAnswer) oldModel.countWrongAnswer + 1 else oldModel.countWrongAnswer

            val newModel = oldModel.copy(
                isCorrect = isCorrectAnswer,
                countWrongAnswer = countWrongAnswer
            )
            _singleQuestion.value = SingleQuestionState.Answer(modelQuestions = newModel)
        }

    }

    fun setInitial() {
        _singleQuestion.value = SingleQuestionState.Initial
    }

    sealed class SingleQuestionState {
        object Initial : SingleQuestionState()
        class Result(val modelQuestions: ModelQuestions) : SingleQuestionState()
        class Answer(val modelQuestions: ModelQuestions) : SingleQuestionState()
        object Victory : SingleQuestionState()
    }
}