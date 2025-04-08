package com.multiplying_numbers.domain.usecase.table_usecase.subtraction

import com.multiplying_numbers.domain.models.ModelTabForCard
import com.multiplying_numbers.domain.repository.RepositoryListTablesSubtraction
import javax.inject.Inject

class GetListTablesSubtractionUseCase @Inject constructor(
    private val repositoryListTablesSubtraction: RepositoryListTablesSubtraction
) {
    operator fun invoke(): List<ModelTabForCard> {
return  repositoryListTablesSubtraction.getListTablesSubtraction()
    }
}