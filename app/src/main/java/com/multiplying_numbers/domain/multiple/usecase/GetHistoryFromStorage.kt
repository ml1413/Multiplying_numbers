package com.multiplying_numbers.domain.multiple.usecase

import com.multiplying_numbers.data.multiple.storage.sharedPref.ModelHistoryStorage
import com.multiplying_numbers.domain.multiple.models.ModelHistory
import com.multiplying_numbers.domain.multiple.repository.RepositoryHistoryAnswer
import javax.inject.Inject

class GetHistoryFromStorage @Inject constructor(
    private val repositoryHistoryAnswer: RepositoryHistoryAnswer
) {
    operator fun invoke(idTable: Int): ModelHistory? {
      return  repositoryHistoryAnswer.getHistoryFromStorage(idTable=idTable)
    }
}