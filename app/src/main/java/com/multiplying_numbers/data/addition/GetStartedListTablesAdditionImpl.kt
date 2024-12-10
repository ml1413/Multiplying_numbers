package com.multiplying_numbers.data.addition

import com.multiplying_numbers.domain.models.ModelTabForCard
import com.multiplying_numbers.domain.models.TableParams

class GetStartedListTablesAdditionImpl : GetStartedListTablesAddition {
    override fun getListTablesAddition(): List<ModelTabForCard> {
        val list = (1..10).map { table ->
            ModelTabForCard(
                idTable = table * 10,
                listQuestions = (1..10).map { num ->
                    val a = ((table * 10) until (table * 10) + 10).random()
                    val b = (1..(table * 10)).random()
                    "%2d +%3d = ?".format(a, b)
                },
                tableParams = TableParams(emptyList(), "")
            )
        }
        return list
    }
}