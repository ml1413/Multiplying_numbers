package com.multiplying_numbers.presentation.di

import com.multiplying_numbers.data.multiole.GetStartedListTables
import com.multiplying_numbers.data.multiole.GetStartedListTablesImpl
import com.multiplying_numbers.data.repository.multiple.RepositoryListTablesImpl
import com.multiplying_numbers.domain.repository.multiple.RepositoryListTables
import com.multiplying_numbers.domain.usecase.multiple.GenerateTableParamMultipleUseCase
import com.multiplying_numbers.domain.usecase.multiple.GetListTablesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ModuleMultiple {
    @Singleton
    @Provides
    fun provideGetListTablesImpl(): GetStartedListTables = GetStartedListTablesImpl()

    @Provides
    @Singleton
    fun provideRepositoryListTablesImpl(getStartedListTables: GetStartedListTables): RepositoryListTables {
        return RepositoryListTablesImpl(getStartedListTables = getStartedListTables)
    }

    @Provides
    fun provideGetListTablesUseCase(repositoryListTables: RepositoryListTables): GetListTablesUseCase {
        return GetListTablesUseCase(repositoryListTables = repositoryListTables)
    }

    @Provides
    fun provideGenerateTableParamMultipleUseCase(repositoryListTables: RepositoryListTables): GenerateTableParamMultipleUseCase {
        return GenerateTableParamMultipleUseCase(repositoryListTables = repositoryListTables)
    }

}