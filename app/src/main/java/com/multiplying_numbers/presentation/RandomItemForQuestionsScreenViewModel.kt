package com.multiplying_numbers.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.multiplying_numbers.domain.models.ModelQuestions

class RandomItemForQuestionsScreenViewModel() : ViewModel() {
    private val _item = MutableLiveData<StateItem>(StateItem.Initial)
    val item: LiveData<StateItem> = _item
    fun setItem(listItem: List<ModelQuestions>) {
        if (_item.value == StateItem.Initial) {
            listItem.filter { it.isCorrect == false || it.isCorrect == null }
                .apply {

                    if (this.isNotEmpty()) {
                        val item = random().let {
                            it.copy(
                                questionSingle = it.questionOnTable + it.randomAnswer
                            )
                        }
                        _item.value = StateItem.ResultItem(item = item)
                    } else {
                        _item.value = StateItem.Completed

                    }

                }

        }
    }

    fun checkAnswerYes() {
        val state = _item.value
        if (state is StateItem.ResultItem) {
            val oldValue = state.item
            val isAnswerCorrect = oldValue.correctAnswer == oldValue.randomAnswer
            val newItem = oldValue.copy(
                isCorrect = isAnswerCorrect
            )
            _item.value = StateItem.Answer(item = newItem)
        }

    }

    fun checkAnswerNo() {
        val state = _item.value
        if (state is StateItem.ResultItem) {
            val oldValue = state.item
            val isAnswerCorrect = oldValue.correctAnswer != oldValue.randomAnswer
            val newItem = oldValue.copy(
                isCorrect = isAnswerCorrect
            )
            _item.value = StateItem.Answer(item = newItem)
        }
    }

    fun setInitial() {
        _item.value = StateItem.Initial
    }


    sealed class StateItem() {
        object Initial : StateItem()
        object Loading : StateItem()
        class ResultItem(val item: ModelQuestions) : StateItem()
        class Answer(val item: ModelQuestions) : StateItem()
        object Completed : StateItem()
    }
}