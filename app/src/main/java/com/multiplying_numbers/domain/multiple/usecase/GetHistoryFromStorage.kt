package com.multiplying_numbers.domain.multiple.usecase

import com.multiplying_numbers.domain.multiple.models.ModelHistory
import com.multiplying_numbers.domain.multiple.repository.RepositoryHistoryAnswer
import javax.inject.Inject

class GetHistoryFromStorage @Inject constructor(
    private val repositoryHistoryAnswer: RepositoryHistoryAnswer
) {
    operator fun invoke(keyStorage: String): ModelHistory? {
      return  repositoryHistoryAnswer.getHistoryFromStorage(keyStorage=keyStorage)
    }
}