package com.multiplying_numbers.presentation.di

import com.multiplying_numbers.data.multiple.GetStartedListTablesMultiple
import com.multiplying_numbers.data.multiple.GetStartedListTablesMultipleImpl
import com.multiplying_numbers.data.repository.multiple.RepositoryListTablesMultipleMultipleImpl
import com.multiplying_numbers.domain.repository.RepositoryListTablesMultiple
import com.multiplying_numbers.domain.usecase.table_usecase.multiple.GetListTablesMultipleUseCase
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
    fun provideGetListTablesImpl(): GetStartedListTablesMultiple =
        GetStartedListTablesMultipleImpl()

    @Singleton
    @Provides
    fun provideRepositoryListTablesMultiple(getStartedListTablesMultiple: GetStartedListTablesMultiple): RepositoryListTablesMultiple {
        return RepositoryListTablesMultipleMultipleImpl(getStartedListTablesMultiple = getStartedListTablesMultiple)
    }

    @Provides
    fun provideGetListTablesUseCase(repositoryListTablesMultiple: RepositoryListTablesMultiple): GetListTablesMultipleUseCase {
        return GetListTablesMultipleUseCase(repositoryListTablesMultiple = repositoryListTablesMultiple)
    }


}