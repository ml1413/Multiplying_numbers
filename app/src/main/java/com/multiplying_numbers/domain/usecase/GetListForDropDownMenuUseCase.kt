package com.multiplying_numbers.domain.usecase

import com.multiplying_numbers.domain.models.ModelQuestions

class GetListForDropDownMenuUseCase {
    operator fun invoke() = (2..9).map { ModelQuestions( label = "-$it-", num = it) }
}