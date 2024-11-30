package com.multiplying_numbers.domain.usecase

import com.multiplying_numbers.domain.models.ModelItemTab
import com.multiplying_numbers.domain.repository.RepositorySingleTable
import javax.inject.Inject

class CheckLeftAnswerUseCase @Inject constructor(private val repositorySingleTable: RepositorySingleTable) {
    operator fun invoke(modelItemTab: ModelItemTab): ModelItemTab {
        return repositorySingleTable.checkLeftAnswer(modelItemTab=modelItemTab)
    }

}