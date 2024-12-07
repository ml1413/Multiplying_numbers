package com.multiplying_numbers.domain.multiple.repository

import com.multiplying_numbers.domain.multiple.models.TableParams

interface RepositoryMultiple {
    fun generateParams(idTable: Int): TableParams
}