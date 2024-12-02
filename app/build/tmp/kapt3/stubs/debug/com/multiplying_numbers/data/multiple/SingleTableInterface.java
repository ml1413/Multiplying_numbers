package com.multiplying_numbers.data.multiple;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/multiplying_numbers/data/multiple/SingleTableInterface;", "", "checkLeftAnswer", "Lcom/multiplying_numbers/domain/multiple/models/ModelSingleTab;", "modelSingleTab", "checkRightAnswer", "getListTables", "idTable", "", "app_debug"})
public abstract interface SingleTableInterface {
    
    @org.jetbrains.annotations.NotNull
    public abstract com.multiplying_numbers.domain.multiple.models.ModelSingleTab getListTables(int idTable);
    
    @org.jetbrains.annotations.NotNull
    public abstract com.multiplying_numbers.domain.multiple.models.ModelSingleTab checkLeftAnswer(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.domain.multiple.models.ModelSingleTab modelSingleTab);
    
    @org.jetbrains.annotations.NotNull
    public abstract com.multiplying_numbers.domain.multiple.models.ModelSingleTab checkRightAnswer(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.domain.multiple.models.ModelSingleTab modelSingleTab);
}