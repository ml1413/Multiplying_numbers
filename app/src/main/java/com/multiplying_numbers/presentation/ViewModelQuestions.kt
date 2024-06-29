package com.multiplying_numbers.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.multiplying_numbers.domain.models.ModelQuestions
import com.multiplying_numbers.domain.usecase.GetListQuestionsUseCase

class ViewModelQuestions(
    private val getListQuestionsUseCase: GetListQuestionsUseCase
) : ViewModel() {
    private val _listQuestions = MutableLiveData<StateQuestions>(StateQuestions.Initial)
    val listQuestions: LiveData<StateQuestions> = _listQuestions

    fun getList(modelQuestions: ModelQuestions) {
        val list = getListQuestionsUseCase(modelQuestions = modelQuestions)
        _listQuestions.value = StateQuestions.Result(list = list)
    }

    sealed class StateQuestions() {
        object Initial : StateQuestions()
        object Loading : StateQuestions()
        class Result(val list: List<ModelQuestions>) : StateQuestions()
    }
}