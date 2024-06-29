package com.multiplying_numbers.data.storage

import com.multiplying_numbers.domain.models.ModelQuestions
import kotlin.random.Random

class GetListStorageImpl : Storage {
    override fun getListQuestions(modelQuestions: ModelQuestions): List<ModelQuestions> {
        val list = (1..10).map {
            modelQuestions.copy(
                questionOnTable = "${modelQuestions.num}  *  $it  = ?",
                correctAnswer = modelQuestions.num * it
            ).let { model ->
                model.copy(randomAnswer = model.correctAnswer + Random.nextInt(0, 2))
            }.let { model ->
                model.copy(
                    questionSingle = model.questionOnTable.replace(
                        "?",
                        model.randomAnswer.toString()
                    )
                )

            }
        }
        return list
    }
}