package com.multiplying_numbers.presentation.di

import com.multiplying_numbers.data.division.GetStartedListTablesDivision
import com.multiplying_numbers.data.division.GetStartedListTablesDivisionImpl
import com.multiplying_numbers.data.repository.division.RepositoryListTablesDivisionImpl
import com.multiplying_numbers.domain.repository.RepositoryListTablesDivision
import com.multiplying_numbers.domain.usecase.division.GetListTableDivisionUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ModuleDivision {
    @Singleton
    @Provides
    fun provideGetStartedListTablesDivisionImpl(): GetStartedListTablesDivision =
        GetStartedListTablesDivisionImpl()

    @Provides
    @Singleton
    fun provideRepositoryListTablesDivisionImpl(getStartedListTablesDivision: GetStartedListTablesDivision): RepositoryListTablesDivision {
        return RepositoryListTablesDivisionImpl(getStartedListTablesDivision = getStartedListTablesDivision)
    }

    @Provides
    fun provideGetListTableDivisionUseCase(repositoryListTablesDivision: RepositoryListTablesDivision): GetListTableDivisionUseCase {
        return GetListTableDivisionUseCase(repositoryListTablesDivision = repositoryListTablesDivision)
    }



}