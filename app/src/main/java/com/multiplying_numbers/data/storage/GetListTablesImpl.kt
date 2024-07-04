package com.multiplying_numbers.data.storage

import com.multiplying_numbers.domain.models.ModelQuestions2

class GetListTablesImpl : GetListTables {
    override fun getListTables(): List<List<ModelQuestions2>> {
        val list = (2..9).map { table ->
            (1..10).map { num ->
                val questions = "$table  *  $num = ?"
                ModelQuestions2(
                    id = table,
                    num = num,
                    questions = questions,
                )
            }
        }
        return list
    }
}

