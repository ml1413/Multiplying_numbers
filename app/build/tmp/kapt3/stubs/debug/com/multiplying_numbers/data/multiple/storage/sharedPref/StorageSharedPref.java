package com.multiplying_numbers.data.multiple.storage.sharedPref;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/multiplying_numbers/data/multiple/storage/sharedPref/StorageSharedPref;", "", "checkHistory", "", "idTable", "", "getHistoryFromStorage", "Lcom/multiplying_numbers/domain/multiple/models/ModelHistory;", "saveInStorage", "", "modelSingleTab", "Lcom/multiplying_numbers/domain/multiple/models/ModelSingleTab;", "app_debug"})
public abstract interface StorageSharedPref {
    
    public abstract void saveInStorage(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.domain.multiple.models.ModelSingleTab modelSingleTab);
    
    @org.jetbrains.annotations.Nullable
    public abstract com.multiplying_numbers.domain.multiple.models.ModelHistory getHistoryFromStorage(int idTable);
    
    public abstract boolean checkHistory(int idTable);
}