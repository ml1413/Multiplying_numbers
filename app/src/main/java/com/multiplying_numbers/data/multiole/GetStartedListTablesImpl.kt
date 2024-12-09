package com.multiplying_numbers.data.multiole

import com.multiplying_numbers.domain.models.multiple.ModelTabForCard
import com.multiplying_numbers.domain.models.Params
import com.multiplying_numbers.domain.models.TableParams

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
            keyStorage = KEY_FOR_STORAGE + idTable,
            paramsList = list
        )
    }

    companion object {
        private const val KEY_FOR_STORAGE = "multiple"
    }

}