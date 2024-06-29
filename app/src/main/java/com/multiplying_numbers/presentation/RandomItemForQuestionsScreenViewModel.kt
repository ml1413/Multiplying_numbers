package com.multiplying_numbers.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.multiplying_numbers.domain.models.ModelQuestions

class RandomItemForQuestionsScreenViewModel() : ViewModel() {
    private val _item = MutableLiveData<StateItem>(StateItem.Initial)
    val item: LiveData<StateItem> = _item
    fun setItem(listItem :List<ModelQuestions>) {
        if (_item.value == StateItem.Initial) {
            val randomItem = listItem
                .filter { !it.isCorrect }
                .random()
            _item.value = StateItem.ResultItem(item = randomItem)
        }
    }
    fun setInitial() {
        _item.value = StateItem.Initial
    }

    sealed class StateItem() {
        object Initial : StateItem()
        object Loading : StateItem()
        class ResultItem(val item: ModelQuestions) : StateItem()
    }
}