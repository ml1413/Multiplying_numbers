package com.multiplying_numbers.presentation.di

import com.multiplying_numbers.data.repository.with_brackets.RepositoryTablesWithBracketsImpl
import com.multiplying_numbers.data.with_brackets.GetStartedListTablesWithBrackets
import com.multiplying_numbers.data.with_brackets.GetStartedListTablesWithBracketsImpl
import com.multiplying_numbers.domain.repository.RepositoryTablesWithBrackets
import com.multiplying_numbers.domain.usecase.table_usecase.with_brackets.GetListTablesWithBracketsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ModuleWithBrackets {
    @Provides
    @Singleton
    fun provideGetStartedListTablesWithBrackets(): GetStartedListTablesWithBrackets {
        return GetStartedListTablesWithBracketsImpl()
    }

    @Provides
    @Singleton
    fun provideRepositoryTablesWithBrackets(getStartedListTablesWithBrackets: GetStartedListTablesWithBrackets): RepositoryTablesWithBrackets {
        return RepositoryTablesWithBracketsImpl(
            getStartedListTablesWithBrackets = getStartedListTablesWithBrackets
        )
    }

    @Provides
    fun provideGetListTablesWithBracketsUseCase(repositoryTablesWithBrackets: RepositoryTablesWithBrackets): GetListTablesWithBracketsUseCase {
        return GetListTablesWithBracketsUseCase(repositoryTablesWithBrackets = repositoryTablesWithBrackets)
    }

}