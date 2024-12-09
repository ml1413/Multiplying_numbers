package com.multiplying_numbers.presentation.di

import android.content.Context
import android.content.SharedPreferences
import com.multiplying_numbers.data.multiole.GetStartedListTables
import com.multiplying_numbers.data.multiole.GetStartedListTablesImpl
import com.multiplying_numbers.data.SingleTableInterface
import com.multiplying_numbers.data.SingleTableInterfaceImpl
import com.multiplying_numbers.data.WrongAnswerSignal
import com.multiplying_numbers.data.WrongAnswerSignalImpl
import com.multiplying_numbers.data.repository.RepositoryHistoryAnswerImpl
import com.multiplying_numbers.data.repository.multiple.RepositoryListTablesImpl
import com.multiplying_numbers.data.repository.RepositorySingleTableImpl
import com.multiplying_numbers.data.storage.sharedPref.StorageSharedPref
import com.multiplying_numbers.data.storage.sharedPref.StorageSharedPrefImpl
import com.multiplying_numbers.domain.repository.RepositoryHistoryAnswer
import com.multiplying_numbers.domain.repository.multiple.RepositoryListTables
import com.multiplying_numbers.domain.repository.RepositorySingleTable
import com.multiplying_numbers.domain.usecase.CheckHistoryUseCase
import com.multiplying_numbers.domain.usecase.CheckLeftAnswerUseCase
import com.multiplying_numbers.domain.usecase.CheckRightAnswerUseCase
import com.multiplying_numbers.domain.usecase.multiple.GenerateTableParamMultipleUseCase
import com.multiplying_numbers.domain.usecase.GetHistoryFromStorage
import com.multiplying_numbers.domain.usecase.multiple.GetListTablesUseCase
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
    @Singleton
    fun provideSharedPref(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences(
            StorageSharedPrefImpl.MANE_FOR_SHARED,
            Context.MODE_PRIVATE
        )
    }




    @Provides
    @Singleton
    fun provideWrongAnswerSignalImpl(@ApplicationContext context: Context): WrongAnswerSignal {
        return WrongAnswerSignalImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideSingleTableInterfaceImpl(wrongAnswerSignal: WrongAnswerSignal): SingleTableInterface {
        return SingleTableInterfaceImpl(signal = wrongAnswerSignal)
    }

    @Provides
    @Singleton
    fun provideRepositorySingleTableImpl(
        singleTableInterface: SingleTableInterface, storageSharedPref: StorageSharedPref
    ): RepositorySingleTable {
        return RepositorySingleTableImpl(
            singleTableInterface = singleTableInterface,
            storageSharedPref = storageSharedPref
        )
    }

    @Provides
    @Singleton
    fun provideRepositoryHistoryAnswerImpl(storageSharedPref: StorageSharedPref): RepositoryHistoryAnswer {
        return RepositoryHistoryAnswerImpl(storageSharedPref = storageSharedPref)
    }

    @Provides
    @Singleton
    fun provideStorageSharedImpl(sharedPreferences: SharedPreferences): StorageSharedPref {
        return StorageSharedPrefImpl(sharedPreferences = sharedPreferences)
    }


    @Provides
    fun provideGetSingleTableUseCase(repositorySingleTable: RepositorySingleTable): GetSingleTableUseCase {
        return GetSingleTableUseCase(repositorySingleTable = repositorySingleTable)
    }

    @Provides
    fun provideCheckLeftAnswerUseCase(repositorySingleTable: RepositorySingleTable): CheckLeftAnswerUseCase {
        return CheckLeftAnswerUseCase(repositorySingleTable = repositorySingleTable)
    }

    @Provides
    fun providesCheckRightAnswerUseCase(repositorySingleTable: RepositorySingleTable): CheckRightAnswerUseCase {
        return CheckRightAnswerUseCase(repositorySingleTable = repositorySingleTable)
    }

    @Provides
    fun provideSaveInStorageUseCase(repositorySingleTable: RepositorySingleTable): SaveInStorageUseCase {
        return SaveInStorageUseCase(repositorySingleTable = repositorySingleTable)
    }

    @Provides
    fun providesGetHistoryFromStorage(repositoryHistoryAnswer: RepositoryHistoryAnswer): GetHistoryFromStorage {
        return GetHistoryFromStorage(repositoryHistoryAnswer = repositoryHistoryAnswer)
    }

    @Provides
    fun provideCheckHistoryUseCase(repositorySingleTable: RepositorySingleTable): CheckHistoryUseCase {
        return CheckHistoryUseCase(repositorySingleTable = repositorySingleTable)
    }


}