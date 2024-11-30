package com.multiplying_numbers.domain.usecase

import com.multiplying_numbers.domain.models.ModelHistory
import com.multiplying_numbers.domain.repository.RepositoryHistoryAnswer
import javax.inject.Inject

class GetHistoryFromStorage @Inject constructor(
    private val repositoryHistoryAnswer: RepositoryHistoryAnswer
) {
    operator fun invoke(idTable: Int): ModelHistory? {
      return  repositoryHistoryAnswer.getHistoryFromStorage(idTable=idTable)
    }
}