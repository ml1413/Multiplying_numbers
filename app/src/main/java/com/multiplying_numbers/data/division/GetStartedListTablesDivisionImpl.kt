package com.multiplying_numbers.data.division

import com.multiplying_numbers.domain.models.ModelTabForCard
import com.multiplying_numbers.domain.models.Params
import com.multiplying_numbers.domain.models.TableParams

class GetStartedListTablesDivisionImpl : GetStartedListTablesDivision {
    override fun getListTablesDivision(): List<ModelTabForCard> {
        val list = (2..9).map { table ->

            ModelTabForCard(
                idTable = table,
                listQuestions = (1..10).map { num ->
                    val a = table * num
                    val b = table
                    "%2d ÷%2d = ?".format(a, b)
                }, tableParams = generateTableParamDivision(idTable = table)
            )
        }
        return list
    }

    private fun generateTableParamDivision(idTable: Int): TableParams {
        val list = (1..10).map { num ->
            val answer = (idTable * num) / idTable
            val questionString = "%2d ÷%2d = ? ".format((idTable * num), idTable)
            val answerString = "%2d ÷%2d =%2d ".format((idTable * num), idTable, answer)
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
        private const val KEY_FOR_STORAGE = "division"
    }
}