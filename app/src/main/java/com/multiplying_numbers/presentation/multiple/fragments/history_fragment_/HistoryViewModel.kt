package com.multiplying_numbers.presentation.multiple.fragments.history_fragment_

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.multiplying_numbers.domain.multiple.models.ModelHistory
import com.multiplying_numbers.domain.multiple.usecase.GetHistoryFromStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val getHistoryFromStorageREFACTOR: GetHistoryFromStorage
) : ViewModel() {
    private val _history = MutableLiveData<StateHistory>(StateHistory.Initial)
    val history: LiveData<StateHistory> = _history

    fun getHistoryFromStorage(idTable: Int) {
        val modelHistory = getHistoryFromStorageREFACTOR(idTable = idTable)
        modelHistory?.apply {
            _history.value = StateHistory.HistoryAnswer(modelHistory = modelHistory)
        }
    }

    sealed class StateHistory() {
        object Initial : StateHistory()
        class HistoryAnswer(val modelHistory: ModelHistory) : StateHistory()
    }
}