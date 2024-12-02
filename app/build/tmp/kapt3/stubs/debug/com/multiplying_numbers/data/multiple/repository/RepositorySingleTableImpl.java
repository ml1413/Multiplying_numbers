package com.multiplying_numbers.data.multiple.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/multiplying_numbers/data/multiple/repository/RepositorySingleTableImpl;", "Lcom/multiplying_numbers/domain/multiple/repository/RepositorySingleTable;", "singleTableInterface", "Lcom/multiplying_numbers/data/multiple/SingleTableInterface;", "storageSharedPref", "Lcom/multiplying_numbers/data/multiple/storage/sharedPref/StorageSharedPref;", "(Lcom/multiplying_numbers/data/multiple/SingleTableInterface;Lcom/multiplying_numbers/data/multiple/storage/sharedPref/StorageSharedPref;)V", "checkHistory", "", "idTable", "", "checkLeftAnswer", "Lcom/multiplying_numbers/domain/multiple/models/ModelSingleTab;", "modelSingleTab", "checkRightAnswer", "getTable", "saveInStorage", "", "app_debug"})
public final class RepositorySingleTableImpl implements com.multiplying_numbers.domain.multiple.repository.RepositorySingleTable {
    @org.jetbrains.annotations.NotNull
    private final com.multiplying_numbers.data.multiple.SingleTableInterface singleTableInterface = null;
    @org.jetbrains.annotations.NotNull
    private final com.multiplying_numbers.data.multiple.storage.sharedPref.StorageSharedPref storageSharedPref = null;
    
    @javax.inject.Inject
    public RepositorySingleTableImpl(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.data.multiple.SingleTableInterface singleTableInterface, @org.jetbrains.annotations.NotNull
    com.multiplying_numbers.data.multiple.storage.sharedPref.StorageSharedPref storageSharedPref) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.multiplying_numbers.domain.multiple.models.ModelSingleTab getTable(int idTable) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.multiplying_numbers.domain.multiple.models.ModelSingleTab checkLeftAnswer(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.domain.multiple.models.ModelSingleTab modelSingleTab) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.multiplying_numbers.domain.multiple.models.ModelSingleTab checkRightAnswer(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.domain.multiple.models.ModelSingleTab modelSingleTab) {
        return null;
    }
    
    @java.lang.Override
    public void saveInStorage(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.domain.multiple.models.ModelSingleTab modelSingleTab) {
    }
    
    @java.lang.Override
    public boolean checkHistory(int idTable) {
        return false;
    }
}