package com.multiplying_numbers.data.subtraction

import com.multiplying_numbers.domain.models.ModelTabForCard
import com.multiplying_numbers.domain.models.Params
import com.multiplying_numbers.domain.models.TableParams

class GetStartedListTablesSubtractionImpl : GetStartedListTablesSubtraction {
    override fun getListTablesSubtraction(): List<ModelTabForCard> {
        val list = (1..10).map { table ->
            ModelTabForCard(
                idTable = table*10,
                listQuestions = (1..10).map { _ ->
                    val a = ((table * 10) until (table * 10) + 10).random()
                    val b = (1..(table * 10)).random()
                    "%2d -%3d = ?".format(a, b)
                },
                tableParams = generateTableParamsSubtraction(idTable = table)
            )
        }
        return list
    }

    private fun generateTableParamsSubtraction(idTable: Int): TableParams {
        val list = (1..10).map { num ->
            val a = ((idTable * 10) until (idTable * 10) + 10).random()
            val b = (1..(idTable * 10)).random()
            val answer = a - b
            val questionString = "%2d - %2d = ?".format(a, b)
            val answerString = "%2d - %2d =%3d".format(a, b, answer)
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
        private const val KEY_FOR_STORAGE = "subtraction"
    }
}