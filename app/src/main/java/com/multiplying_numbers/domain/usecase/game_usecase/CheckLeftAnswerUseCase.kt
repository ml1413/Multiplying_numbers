package com.multiplying_numbers.domain.usecase.game_usecase

import com.multiplying_numbers.domain.models.ModelSingleTab
import com.multiplying_numbers.domain.repository.RepositorySingleTable
import javax.inject.Inject

class CheckLeftAnswerUseCase @Inject constructor(private val repositorySingleTable: RepositorySingleTable) {
    operator fun invoke(modelSingleTab: ModelSingleTab): ModelSingleTab {
        return repositorySingleTable.checkLeftAnswer(modelSingleTab=modelSingleTab)
    }

}