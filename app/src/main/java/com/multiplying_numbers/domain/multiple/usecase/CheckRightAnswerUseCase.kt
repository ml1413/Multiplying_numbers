package com.multiplying_numbers.domain.multiple.usecase

import com.multiplying_numbers.domain.multiple.models.ModelSingleTab
import com.multiplying_numbers.domain.multiple.repository.RepositorySingleTable
import javax.inject.Inject

class CheckRightAnswerUseCase @Inject constructor(
    private val repositorySingleTable: RepositorySingleTable
) {
    operator fun invoke(modelSingleTab: ModelSingleTab): ModelSingleTab {
        return repositorySingleTable.checkRightAnswer(modelSingleTab = modelSingleTab)
    }
}