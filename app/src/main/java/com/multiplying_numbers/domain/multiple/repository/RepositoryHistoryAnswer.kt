package com.multiplying_numbers.domain.multiple.repository

import com.multiplying_numbers.domain.multiple.models.ModelHistory

interface RepositoryHistoryAnswer {
    fun getHistoryFromStorage(idTable: Int): ModelHistory?
}