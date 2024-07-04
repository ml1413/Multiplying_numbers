package com.multiplying_numbers.data.storage

import com.multiplying_numbers.domain.models.ModelQuestions2

interface GetListTables {
    fun getListTables(): List<List<ModelQuestions2>>
}