package com.multiplying_numbers.presentation.di

import com.multiplying_numbers.data.repository.subtraction.RepositoryListTablesSubtractionImpl
import com.multiplying_numbers.data.subtraction.GetStartedListTablesSubtraction
import com.multiplying_numbers.data.subtraction.GetStartedListTablesSubtractionImpl
import com.multiplying_numbers.domain.repository.RepositoryListTablesSubtraction
import com.multiplying_numbers.domain.usecase.table_usecase.subtraction.GetListTablesSubtractionUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ModuleSubtraction {
    @Provides
    @Singleton
    fun provideGetStartedListTablesSubtractionImpl(): GetStartedListTablesSubtraction {
        return GetStartedListTablesSubtractionImpl()
    }

    @Singleton
    @Provides
    fun provideRepositoryListTablesSubtractionImpl(getStartedListTablesSubtraction: GetStartedListTablesSubtraction): RepositoryListTablesSubtraction {
        return RepositoryListTablesSubtractionImpl(getStartedListTablesSubtraction = getStartedListTablesSubtraction)
    }

    @Provides
    fun provideGetListTablesSubtractionUseCase(repositoryListTablesSubtraction: RepositoryListTablesSubtraction): GetListTablesSubtractionUseCase {
        return GetListTablesSubtractionUseCase(repositoryListTablesSubtraction = repositoryListTablesSubtraction)
    }
}