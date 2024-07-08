package com.multiplying_numbers.data.storage

import com.multiplying_numbers.domain.models.ModelQuestions

class GetListTablesImpl : GetListTables {
    override fun getListTables(): List<List<ModelQuestions>> {
        val list = (2..9).map { table ->
            (1..10).map { num ->
                val questions = "$table  *  $num = ?"
                ModelQuestions(
                    id = table,
                    num = num,
                    questions = questions,
                )
            }
        }
        return list
    }
}

