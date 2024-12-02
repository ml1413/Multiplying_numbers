package com.multiplying_numbers.presentation.di;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\b\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\nH\u0007J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u001f\u001a\u00020 2\b\b\u0001\u0010!\u001a\u00020\"H\u0007J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010$\u001a\u00020 H\u0007J\u0012\u0010%\u001a\u00020\u000e2\b\b\u0001\u0010!\u001a\u00020\"H\u0007J\u0010\u0010&\u001a\u00020\'2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0016H\u0007\u00a8\u0006+"}, d2 = {"Lcom/multiplying_numbers/presentation/di/Module;", "", "()V", "provideCheckAnswerUseCaseREFACTOR", "Lcom/multiplying_numbers/domain/multiple/usecase/CheckLeftAnswerUseCase;", "repositorySingleTable", "Lcom/multiplying_numbers/domain/multiple/repository/RepositorySingleTable;", "provideCheckHistoryUseCase", "Lcom/multiplying_numbers/domain/multiple/usecase/CheckHistoryUseCase;", "provideGetListTablesImpl", "Lcom/multiplying_numbers/data/multiple/GetStartedListTables;", "provideGetListTablesImplREFACTOR", "Lcom/multiplying_numbers/data/multiple/SingleTableInterface;", "wrongAnswerSignal", "Lcom/multiplying_numbers/data/multiple/WrongAnswerSignal;", "provideGetListTablesUseCase", "Lcom/multiplying_numbers/domain/multiple/usecase/GetListTablesUseCase;", "repositoryListTables", "Lcom/multiplying_numbers/domain/multiple/repository/RepositoryListTables;", "provideGetSingleTableUseCaseREFACTOR", "Lcom/multiplying_numbers/domain/multiple/usecase/GetSingleTableUseCase;", "provideRepositoryHistoryAnswerImplREFACTOR", "Lcom/multiplying_numbers/domain/multiple/repository/RepositoryHistoryAnswer;", "storageSharedPref", "Lcom/multiplying_numbers/data/multiple/storage/sharedPref/StorageSharedPref;", "provideRepositoryListTablesImpl", "getStartedListTables", "provideRepositorySingleTableREFACTORImpl", "singleTableInterface", "provideSaveInStorageUseCaseREFACTOR", "Lcom/multiplying_numbers/domain/multiple/usecase/SaveInStorageUseCase;", "provideSharedPref", "Landroid/content/SharedPreferences;", "context", "Landroid/content/Context;", "provideStorageSharedImpl", "sharedPreferences", "provideWrongAnswerSignalImpl", "providesCheckRightAnswerUseCaseREFACTOR", "Lcom/multiplying_numbers/domain/multiple/usecase/CheckRightAnswerUseCase;", "providesGetHistoryFromStorageREFACTOR", "Lcom/multiplying_numbers/domain/multiple/usecase/GetHistoryFromStorage;", "repositoryHistoryAnswer", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class Module {
    
    public Module() {
        super();
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.multiplying_numbers.data.multiple.GetStartedListTables provideGetListTablesImpl() {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final android.content.SharedPreferences provideSharedPref(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.multiplying_numbers.domain.multiple.usecase.GetListTablesUseCase provideGetListTablesUseCase(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.domain.multiple.repository.RepositoryListTables repositoryListTables) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.multiplying_numbers.domain.multiple.repository.RepositoryListTables provideRepositoryListTablesImpl(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.data.multiple.GetStartedListTables getStartedListTables) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.multiplying_numbers.data.multiple.WrongAnswerSignal provideWrongAnswerSignalImpl(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.multiplying_numbers.data.multiple.SingleTableInterface provideGetListTablesImplREFACTOR(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.data.multiple.WrongAnswerSignal wrongAnswerSignal) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.multiplying_numbers.domain.multiple.repository.RepositorySingleTable provideRepositorySingleTableREFACTORImpl(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.data.multiple.SingleTableInterface singleTableInterface, @org.jetbrains.annotations.NotNull
    com.multiplying_numbers.data.multiple.storage.sharedPref.StorageSharedPref storageSharedPref) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.multiplying_numbers.domain.multiple.repository.RepositoryHistoryAnswer provideRepositoryHistoryAnswerImplREFACTOR(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.data.multiple.storage.sharedPref.StorageSharedPref storageSharedPref) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.multiplying_numbers.data.multiple.storage.sharedPref.StorageSharedPref provideStorageSharedImpl(@org.jetbrains.annotations.NotNull
    android.content.SharedPreferences sharedPreferences) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.multiplying_numbers.domain.multiple.usecase.GetSingleTableUseCase provideGetSingleTableUseCaseREFACTOR(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.domain.multiple.repository.RepositorySingleTable repositorySingleTable) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.multiplying_numbers.domain.multiple.usecase.CheckLeftAnswerUseCase provideCheckAnswerUseCaseREFACTOR(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.domain.multiple.repository.RepositorySingleTable repositorySingleTable) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.multiplying_numbers.domain.multiple.usecase.CheckRightAnswerUseCase providesCheckRightAnswerUseCaseREFACTOR(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.domain.multiple.repository.RepositorySingleTable repositorySingleTable) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.multiplying_numbers.domain.multiple.usecase.SaveInStorageUseCase provideSaveInStorageUseCaseREFACTOR(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.domain.multiple.repository.RepositorySingleTable repositorySingleTable) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.multiplying_numbers.domain.multiple.usecase.GetHistoryFromStorage providesGetHistoryFromStorageREFACTOR(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.domain.multiple.repository.RepositoryHistoryAnswer repositoryHistoryAnswer) {
        return null;
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final com.multiplying_numbers.domain.multiple.usecase.CheckHistoryUseCase provideCheckHistoryUseCase(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.domain.multiple.repository.RepositorySingleTable repositorySingleTable) {
        return null;
    }
}