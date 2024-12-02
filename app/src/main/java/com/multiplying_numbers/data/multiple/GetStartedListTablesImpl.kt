package com.multiplying_numbers.data.multiple

import com.multiplying_numbers.domain.multiple.models.ModelTabForCard

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

}