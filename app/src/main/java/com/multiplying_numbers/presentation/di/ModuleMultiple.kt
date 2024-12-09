package com.multiplying_numbers.presentation.di

import com.multiplying_numbers.data.multiole.GetStartedListTablesMultiple
import com.multiplying_numbers.data.multiole.GetStartedListTablesMultipleImpl
import com.multiplying_numbers.domain.repository.RepositoryListTablesMultiple
import com.multiplying_numbers.domain.usecase.multiple.GenerateTableParamMultipleUseCase
import com.multiplying_numbers.domain.usecase.multiple.GetListTablesMultipleUseCase
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
    fun provideGetListTablesImpl(): GetStartedListTablesMultiple = GetStartedListTablesMultipleImpl()


    @Provides
    fun provideGetListTablesUseCase(repositoryListTablesMultiple: RepositoryListTablesMultiple): GetListTablesMultipleUseCase {
        return GetListTablesMultipleUseCase(repositoryListTablesMultiple = repositoryListTablesMultiple)
    }

    @Provides
    fun provideGenerateTableParamMultipleUseCase(repositoryListTablesMultiple: RepositoryListTablesMultiple): GenerateTableParamMultipleUseCase {
        return GenerateTableParamMultipleUseCase(repositoryListTablesMultiple = repositoryListTablesMultiple)
    }

}