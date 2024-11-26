package com.multiplying_numbers.presentation.di

import android.content.Context
import android.content.SharedPreferences
import com.multiplying_numbers.data.repository.RepositoryListResultImpl
import com.multiplying_numbers.data.repository.RepositoryListTablesImpl
import com.multiplying_numbers.data.storage.GetListTables
import com.multiplying_numbers.data.storage.GetListTablesImpl
import com.multiplying_numbers.data.storage.StorageListResult
import com.multiplying_numbers.data.storage.StorageListResultSharedImpl
import com.multiplying_numbers.domain.repository.RepositoryListResult
import com.multiplying_numbers.domain.repository.RepositoryListTables
import com.multiplying_numbers.domain.usecase.GetListResultUseCase
import com.multiplying_numbers.domain.usecase.GetListTablesUseCase
import com.multiplying_numbers.domain.usecase.SaveListResultUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Module {

    @Provides
    fun provideGetListTablesImpl(): GetListTables = GetListTablesImpl()

    @Provides
    @Singleton
    fun provideSharedPref(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(
            StorageListResultSharedImpl.SHARED_NAME,
            Context.MODE_PRIVATE
        )
    }

    @Provides
    @Singleton
    fun provideRepositoryListTablesImpl(getListTables: GetListTables): RepositoryListTables {
        return RepositoryListTablesImpl(getListTables = getListTables)
    }

    @Provides
    fun provideGetListTablesUseCase(repositoryListTables: RepositoryListTables): GetListTablesUseCase {
        return GetListTablesUseCase(repositoryListTables = repositoryListTables)
    }

    @Provides
    fun provideStorageListResultSharedImpl(sharedPreferences: SharedPreferences): StorageListResult {
        return StorageListResultSharedImpl(sharedPreferences = sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideRepositoryListResultImpl(storageListResult: StorageListResult): RepositoryListResult {
        return RepositoryListResultImpl(storageListResult = storageListResult)
    }

    @Provides
    fun provideSaveListResultUseCase(repositoryListResult: RepositoryListResult): SaveListResultUseCase {
        return SaveListResultUseCase(repositoryListResult = repositoryListResult)
    }

    @Provides
    fun provideGetListResultUseCase(repositoryListResult: RepositoryListResult): GetListResultUseCase {
        return GetListResultUseCase(repositoryListResult = repositoryListResult)
    }
}