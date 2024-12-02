package com.multiplying_numbers.data.multiple.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/multiplying_numbers/data/multiple/repository/RepositoryHistoryAnswerImpl;", "Lcom/multiplying_numbers/domain/multiple/repository/RepositoryHistoryAnswer;", "storageSharedPref", "Lcom/multiplying_numbers/data/multiple/storage/sharedPref/StorageSharedPref;", "(Lcom/multiplying_numbers/data/multiple/storage/sharedPref/StorageSharedPref;)V", "getHistoryFromStorage", "Lcom/multiplying_numbers/domain/multiple/models/ModelHistory;", "idTable", "", "app_debug"})
public final class RepositoryHistoryAnswerImpl implements com.multiplying_numbers.domain.multiple.repository.RepositoryHistoryAnswer {
    @org.jetbrains.annotations.NotNull
    private final com.multiplying_numbers.data.multiple.storage.sharedPref.StorageSharedPref storageSharedPref = null;
    
    @javax.inject.Inject
    public RepositoryHistoryAnswerImpl(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.data.multiple.storage.sharedPref.StorageSharedPref storageSharedPref) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public com.multiplying_numbers.domain.multiple.models.ModelHistory getHistoryFromStorage(int idTable) {
        return null;
    }
}