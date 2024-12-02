package com.multiplying_numbers.domain.multiple.usecase

import com.multiplying_numbers.domain.multiple.models.ModelItemTab
import com.multiplying_numbers.domain.multiple.repository.RepositorySingleTable
import javax.inject.Inject

class CheckRightAnswerUseCase @Inject constructor(
    private val repositorySingleTable: RepositorySingleTable
) {
    operator fun invoke(modelItemTab: ModelItemTab): ModelItemTab {
        return repositorySingleTable.checkRightAnswer(modelItemTab = modelItemTab)
    }
}