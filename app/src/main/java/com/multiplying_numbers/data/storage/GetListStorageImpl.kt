package com.multiplying_numbers.data.storage

import com.multiplying_numbers.domain.models.ModelQuestions

class GetListStorageImpl : Storage {
    override fun getListQuestions(modelQuestions: ModelQuestions): List<ModelQuestions> {
        val list = (1..10).map {
            modelQuestions.copy(
                id = it,
                questionOnTable = "${modelQuestions.num}  *  $it  = ",
                correctAnswer = modelQuestions.num * it
            ).let { model ->
                model.copy(randomAnswer = model.correctAnswer + (0..3).random())
            }
        }
        return list
    }
}