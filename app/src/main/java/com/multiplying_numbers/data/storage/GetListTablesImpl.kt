package com.multiplying_numbers.data.storage

import com.multiplying_numbers.domain.models.ModelTabForCard

class GetListTablesImpl : GetListTables {

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

