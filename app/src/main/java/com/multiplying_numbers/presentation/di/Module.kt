package com.multiplying_numbers.presentation.di

import android.content.Context
import android.content.SharedPreferences
import com.multiplying_numbers.data.multiple.repository.RepositoryHistoryAnswerImpl
import com.multiplying_numbers.data.multiple.repository.RepositoryListTablesImpl
import com.multiplying_numbers.data.multiple.repository.RepositorySingleTableImpl
import com.multiplying_numbers.data.multiple.GetStartedListTables
import com.multiplying_numbers.data.multiple.GetStartedListTablesImpl
import com.multiplying_numbers.data.multiple.SingleTableInterface
import com.multiplying_numbers.data.multiple.SingleTableInterfaceImpl
import com.multiplying_numbers.data.multiple.storage.sharedPref.StorageSharedPref
import com.multiplying_numbers.data.multiple.storage.sharedPref.StorageSharedPrefImpl
import com.multiplying_numbers.domain.multiple.repository.RepositoryHistoryAnswer
import com.multiplying_numbers.domain.multiple.repository.RepositoryListTables
import com.multiplying_numbers.domain.multiple.repository.RepositorySingleTable
import com.multiplying_numbers.domain.multiple.usecase.CheckHistoryUseCase
import com.multiplying_numbers.domain.multiple.usecase.CheckLeftAnswerUseCase
import com.multiplying_numbers.domain.multiple.usecase.CheckRightAnswerUseCase
import com.multiplying_numbers.domain.multiple.usecase.GetHistoryFromStorage
import com.multiplying_numbers.domain.multiple.usecase.GetListTablesUseCase
import com.multiplying_numbers.domain.multiple.usecase.GetSingleTableUseCase
import com.multiplying_numbers.domain.multiple.usecase.SaveInStorageUseCase
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
    fun provideGetListTablesImpl(): GetStartedListTables = GetStartedListTablesImpl()

    @Provides
    @Singleton
    fun provideSharedPref(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(
            StorageSharedPrefImpl.MANE_FOR_SHARED,
            Context.MODE_PRIVATE
        )
    }


    @Provides
    fun provideGetListTablesUseCase(repositoryListTables: RepositoryListTables): GetListTablesUseCase {
        return GetListTablesUseCase(repositoryListTables = repositoryListTables)
    }

    @Provides
    @Singleton
    fun provideRepositoryListTablesImpl(getStartedListTables: GetStartedListTables): RepositoryListTables {
        return RepositoryListTablesImpl(getStartedListTables = getStartedListTables)
    }

    @Provides
    @Singleton
    fun provideGetListTablesImplREFACTOR(): SingleTableInterface {
        return SingleTableInterfaceImpl()
    }

    @Provides
    @Singleton
    fun provideRepositorySingleTableREFACTORImpl(
        singleTableInterface: SingleTableInterface, storageSharedPref: StorageSharedPref
    ): RepositorySingleTable {
        return RepositorySingleTableImpl(
            singleTableInterface = singleTableInterface,
            storageSharedPref = storageSharedPref
        )
    }

    @Provides
    @Singleton
    fun provideRepositoryHistoryAnswerImplREFACTOR(storageSharedPref: StorageSharedPref): RepositoryHistoryAnswer {
        return RepositoryHistoryAnswerImpl(storageSharedPref = storageSharedPref)
    }

    @Provides
    @Singleton
    fun provideStorageSharedImpl(sharedPreferences: SharedPreferences): StorageSharedPref {
        return StorageSharedPrefImpl(sharedPreferences = sharedPreferences)
    }

    @Provides
    fun provideGetSingleTableUseCaseREFACTOR(repositorySingleTable: RepositorySingleTable): GetSingleTableUseCase {
        return GetSingleTableUseCase(repositorySingleTable = repositorySingleTable)
    }

    @Provides
    fun provideCheckAnswerUseCaseREFACTOR(repositorySingleTable: RepositorySingleTable): CheckLeftAnswerUseCase {
        return CheckLeftAnswerUseCase(repositorySingleTable = repositorySingleTable)
    }

    @Provides
    fun providesCheckRightAnswerUseCaseREFACTOR(repositorySingleTable: RepositorySingleTable): CheckRightAnswerUseCase {
        return CheckRightAnswerUseCase(repositorySingleTable = repositorySingleTable)
    }

    @Provides
    fun provideSaveInStorageUseCaseREFACTOR(repositorySingleTable: RepositorySingleTable): SaveInStorageUseCase {
        return SaveInStorageUseCase(repositorySingleTable = repositorySingleTable)
    }

    @Provides
    fun providesGetHistoryFromStorageREFACTOR(repositoryHistoryAnswer: RepositoryHistoryAnswer): GetHistoryFromStorage {
        return GetHistoryFromStorage(repositoryHistoryAnswer = repositoryHistoryAnswer)
    }

    @Provides
    fun provideCheckHistoryUseCase(repositorySingleTable: RepositorySingleTable): CheckHistoryUseCase {
        return CheckHistoryUseCase(repositorySingleTable = repositorySingleTable)
    }

}