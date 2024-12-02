package com.multiplying_numbers.domain.multiple.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0007H&\u00a8\u0006\r"}, d2 = {"Lcom/multiplying_numbers/domain/multiple/repository/RepositorySingleTable;", "", "checkHistory", "", "idTable", "", "checkLeftAnswer", "Lcom/multiplying_numbers/domain/multiple/models/ModelSingleTab;", "modelSingleTab", "checkRightAnswer", "getTable", "saveInStorage", "", "app_debug"})
public abstract interface RepositorySingleTable {
    
    @org.jetbrains.annotations.NotNull
    public abstract com.multiplying_numbers.domain.multiple.models.ModelSingleTab getTable(int idTable);
    
    @org.jetbrains.annotations.NotNull
    public abstract com.multiplying_numbers.domain.multiple.models.ModelSingleTab checkLeftAnswer(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.domain.multiple.models.ModelSingleTab modelSingleTab);
    
    @org.jetbrains.annotations.NotNull
    public abstract com.multiplying_numbers.domain.multiple.models.ModelSingleTab checkRightAnswer(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.domain.multiple.models.ModelSingleTab modelSingleTab);
    
    public abstract void saveInStorage(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.domain.multiple.models.ModelSingleTab modelSingleTab);
    
    public abstract boolean checkHistory(int idTable);
}