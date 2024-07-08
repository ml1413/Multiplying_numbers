package com.multiplying_numbers.data.storage

import com.multiplying_numbers.domain.models.ModelQuestions

interface GetListTables {
    fun getListTables(): List<List<ModelQuestions>>
}