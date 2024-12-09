package com.multiplying_numbers.domain.repository

import com.multiplying_numbers.domain.models.ModelHistory

interface RepositoryHistoryAnswer {
    fun getHistoryFromStorage(keyStorage: String): ModelHistory?
}