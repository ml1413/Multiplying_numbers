package com.multiplying_numbers.presentation.di

import com.multiplying_numbers.data.addition.GetStartedListTablesAddition
import com.multiplying_numbers.data.addition.GetStartedListTablesAdditionImpl
import com.multiplying_numbers.data.repository.addition.RepositoryListTablesAdditionImpl
import com.multiplying_numbers.domain.repository.RepositoryListTablesAddition
import com.multiplying_numbers.domain.usecase.addition.GetListTableAdditionUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ModuleAddition {
    @Singleton
    @Provides
    fun provideGetStartedListTablesAdditionImpl(): GetStartedListTablesAddition {
        return GetStartedListTablesAdditionImpl()
    }

    @Singleton
    @Provides
    fun repositoryListTablesAdditionImpl(getStartedListTablesAddition: GetStartedListTablesAddition): RepositoryListTablesAddition {
        return RepositoryListTablesAdditionImpl(getStartedListTablesAddition = getStartedListTablesAddition)
    }

    @Provides
    fun getListTableAdditionUseCase(repositoryListTablesAddition: RepositoryListTablesAddition): GetListTableAdditionUseCase {
        return GetListTableAdditionUseCase(repositoryListTablesAddition = repositoryListTablesAddition)
    }
}