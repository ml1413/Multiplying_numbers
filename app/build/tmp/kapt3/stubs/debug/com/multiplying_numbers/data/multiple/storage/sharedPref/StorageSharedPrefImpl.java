package com.multiplying_numbers.data.multiple.storage.sharedPref;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/multiplying_numbers/data/multiple/storage/sharedPref/StorageSharedPrefImpl;", "Lcom/multiplying_numbers/data/multiple/storage/sharedPref/StorageSharedPref;", "sharedPreferences", "Landroid/content/SharedPreferences;", "(Landroid/content/SharedPreferences;)V", "checkHistory", "", "idTable", "", "getHistoryFromStorage", "Lcom/multiplying_numbers/domain/multiple/models/ModelHistory;", "getModelForSaveInStorage", "Lcom/multiplying_numbers/data/multiple/storage/sharedPref/ModelHistoryStorage;", "modelSingleTab", "Lcom/multiplying_numbers/domain/multiple/models/ModelSingleTab;", "key", "", "getModelFromStorage", "saveInStorage", "", "Companion", "app_debug"})
public final class StorageSharedPrefImpl implements com.multiplying_numbers.data.multiple.storage.sharedPref.StorageSharedPref {
    @org.jetbrains.annotations.NotNull
    private final android.content.SharedPreferences sharedPreferences = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String MANE_FOR_SHARED = "model for victory";
    @org.jetbrains.annotations.NotNull
    public static final com.multiplying_numbers.data.multiple.storage.sharedPref.StorageSharedPrefImpl.Companion Companion = null;
    
    @javax.inject.Inject
    public StorageSharedPrefImpl(@org.jetbrains.annotations.NotNull
    android.content.SharedPreferences sharedPreferences) {
        super();
    }
    
    @java.lang.Override
    public void saveInStorage(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.domain.multiple.models.ModelSingleTab modelSingleTab) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public com.multiplying_numbers.domain.multiple.models.ModelHistory getHistoryFromStorage(int idTable) {
        return null;
    }
    
    @java.lang.Override
    public boolean checkHistory(int idTable) {
        return false;
    }
    
    /**
     * other method _________________________________________________________________________________
     */
    private final com.multiplying_numbers.data.multiple.storage.sharedPref.ModelHistoryStorage getModelForSaveInStorage(com.multiplying_numbers.domain.multiple.models.ModelSingleTab modelSingleTab, java.lang.String key) {
        return null;
    }
    
    private final com.multiplying_numbers.data.multiple.storage.sharedPref.ModelHistoryStorage getModelFromStorage(java.lang.String key) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/multiplying_numbers/data/multiple/storage/sharedPref/StorageSharedPrefImpl$Companion;", "", "()V", "MANE_FOR_SHARED", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}