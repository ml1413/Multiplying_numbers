package com.multiplying_numbers.data.storage

import com.multiplying_numbers.domain.models.ModelQuestions

class GetListStorageImpl : Storage {
    override fun getListQuestions(modelQuestions: ModelQuestions): List<ModelQuestions> {
        val list = (1..10).map {
            modelQuestions.copy(
                question = "${modelQuestions.num}  *  $it  = ?",
                answer = modelQuestions.num * it
            )
        }
        return list
    }
}