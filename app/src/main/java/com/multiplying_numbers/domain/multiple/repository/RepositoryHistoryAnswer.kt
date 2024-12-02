package com.multiplying_numbers.domain.multiple.repository

import com.multiplying_numbers.data.multiple.storage.sharedPref.ModelHistory

interface RepositoryHistoryAnswer {
    fun getHistoryFromStorage(idTable: Int): ModelHistory?
}