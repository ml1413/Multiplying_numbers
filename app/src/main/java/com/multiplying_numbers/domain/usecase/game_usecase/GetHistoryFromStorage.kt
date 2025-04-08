package com.multiplying_numbers.domain.usecase.game_usecase

import com.multiplying_numbers.domain.models.ModelHistory
import com.multiplying_numbers.domain.repository.RepositoryHistoryAnswer
import javax.inject.Inject

class GetHistoryFromStorage @Inject constructor(
    private val repositoryHistoryAnswer: RepositoryHistoryAnswer
) {
    operator fun invoke(keyStorage: String): ModelHistory? {
      return  repositoryHistoryAnswer.getHistoryFromStorage(keyStorage=keyStorage)
    }
}