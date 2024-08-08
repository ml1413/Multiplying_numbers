package com.multiplying_numbers.presentation.fragment.list_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.multiplying_numbers.domain.models.ModelQuestions
import com.multiplying_numbers.domain.usecase.GetListTablesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListTablesViewModel @Inject constructor(
    private val getListTablesUseCase: GetListTablesUseCase
) : ViewModel() {
    private val _listsTables = MutableLiveData<StateLists>(StateLists.Initial)
    val listsTables: LiveData<StateLists> = _listsTables

    fun getData() {
        val listsTable = getListTablesUseCase.invoke()
        _listsTables.value = StateLists.Result(listsTables = listsTable)
    }

    sealed class StateLists {
        object Initial : StateLists()
        class Result(val listsTables: List<List<ModelQuestions>>) : StateLists()
    }
}