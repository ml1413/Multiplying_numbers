package com.multiplying_numbers.data.multiple

import com.multiplying_numbers.domain.multiple.models.Params
import com.multiplying_numbers.domain.multiple.models.TableParams
import com.multiplying_numbers.domain.multiple.repository.RepositoryMultiple

class RepositoryMultipleImpl : RepositoryMultiple {
    override fun generateParams(idTable: Int): TableParams {
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