package com.multiplying_numbers.presentation.di

import android.content.Context
import android.content.SharedPreferences
import com.multiplying_numbers.data.repository.RepositoryHistoryAnswerImpl
import com.multiplying_numbers.data.repository.RepositoryListTablesImpl
import com.multiplying_numbers.data.repository.RepositorySingleTableImpl
import com.multiplying_numbers.data.storage.GetListTables
import com.multiplying_numbers.data.storage.GetListTablesImpl
import com.multiplying_numbers.data.storage.MultipleNum
import com.multiplying_numbers.data.storage.MultipleNumImpl
import com.multiplying_numbers.data.storage.sharedPref.StorageSharedPref
import com.multiplying_numbers.data.storage.sharedPref.StorageSharedPrefImpl
import com.multiplying_numbers.domain.repository.RepositoryHistoryAnswer
import com.multiplying_numbers.domain.repository.RepositoryListTables
import com.multiplying_numbers.domain.repository.RepositorySingleTable
import com.multiplying_numbers.domain.usecase.CheckLeftAnswerUseCase
import com.multiplying_numbers.domain.usecase.CheckRightAnswerUseCase
import com.multiplying_numbers.domain.usecase.GetHistoryFromStorage
import com.multiplying_numbers.domain.usecase.GetListTablesUseCase
import com.multiplying_numbers.domain.usecase.GetSingleTableUseCase
import com.multiplying_numbers.domain.usecase.SaveInStorageUseCase
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
    fun provideRepositoryListTablesImpl(getListTables: GetListTables): RepositoryListTables {
        return RepositoryListTablesImpl(getListTables = getListTables)
    }

    @Provides
    @Singleton
    fun provideGetListTablesImplREFACTOR(): MultipleNum {
        return MultipleNumImpl()
    }

    @Provides
    @Singleton
    fun provideRepositorySingleTableREFACTORImpl(
        multipleNum: MultipleNum, storageSharedPref: StorageSharedPref
    ): RepositorySingleTable {
        return RepositorySingleTableImpl(
            multipleNum = multipleNum,
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

}