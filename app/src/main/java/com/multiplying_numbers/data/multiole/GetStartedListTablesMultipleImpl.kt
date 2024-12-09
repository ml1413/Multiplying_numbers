package com.multiplying_numbers.data.multiole

import com.multiplying_numbers.domain.models.ModelTabForCard
import com.multiplying_numbers.domain.models.Params
import com.multiplying_numbers.domain.models.TableParams

class GetStartedListTablesMultipleImpl : GetStartedListTablesMultiple {

    override fun getListTables(): List<ModelTabForCard> {
        val list = (2..9).map { table ->
            ModelTabForCard(
                idTable = table,
                listQuestions = (1..10).map { num ->
                    "%2d *%2d = ? ".format(table, num)
                }
            )
        }
        return list
    }

    override fun generateTableParams(idTable: Int): TableParams {
        val list = (1..10).map { num ->
            val answer = idTable * num
            val questionString = "%2d *%2d = ? ".format(idTable, num)
            val answerString = "%2d *%2d =%2d ".format(idTable, num, answer)
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