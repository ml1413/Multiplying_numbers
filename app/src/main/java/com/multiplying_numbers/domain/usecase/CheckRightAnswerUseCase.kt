package com.multiplying_numbers.domain.usecase

import com.multiplying_numbers.domain.models.ModelItemTab
import com.multiplying_numbers.domain.repository.RepositorySingleTable
import javax.inject.Inject

class CheckRightAnswerUseCase @Inject constructor(
    private val repositorySingleTable: RepositorySingleTable
) {
    operator fun invoke(modelItemTab: ModelItemTab): ModelItemTab {
        return repositorySingleTable.checkRightAnswer(modelItemTab = modelItemTab)
    }
}