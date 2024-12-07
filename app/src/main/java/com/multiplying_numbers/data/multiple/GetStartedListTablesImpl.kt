package com.multiplying_numbers.data.multiple

import com.multiplying_numbers.domain.multiple.models.ModelTabForCard
import com.multiplying_numbers.domain.multiple.models.Params
import com.multiplying_numbers.domain.multiple.models.TableParams

class GetStartedListTablesImpl : GetStartedListTables {

    override fun getListTables(): List<ModelTabForCard> {
        val list = (2..9).map { table ->
            ModelTabForCard(
                idTable = table,
                listQuestions = (1..10).map { num -> "$table  *  $num  =  ?" }
            )
        }
        return list
    }

    override fun generateTableParams(idTable: Int): TableParams {
        val list = (1..10).map { num ->
            val answer = idTable * num
            val questionString = "$idTable  *  $num  =  ?"
            val answerString = "$idTable  *  $num  = $answer"
            Params(
                id = num,
                answerValue = answer,
                questionString = questionString,
                answerString = answerString
            )
        }
        return TableParams(
            idTable = idTable,
            paramsList = list
        )
    }

}