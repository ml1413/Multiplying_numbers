package com.multiplying_numbers.data.storage

import com.multiplying_numbers.domain.models.ModelQuestions

class GetListTablesImpl : GetListTables {
    override fun getListTables(): List<List<ModelQuestions>> {
        var id = 0
        val list = (2..9).map { table ->
            (1..10).map { num ->
                id++
                val questions = "$table  *  $num  =  ?"
                val answer = "$table  *  $num  = ${table * num}"
                ModelQuestions(
                    id = id,
                    factor = table,
                    num = num,
                    questions = questions,
                    answer = answer,
                    correctAnswer = table * num
                )

            }
        }
        return list
    }
}

