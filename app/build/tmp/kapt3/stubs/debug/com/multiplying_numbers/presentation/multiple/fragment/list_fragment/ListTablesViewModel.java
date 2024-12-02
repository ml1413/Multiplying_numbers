package com.multiplying_numbers.presentation.multiple.fragment.list_fragment;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000eB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/multiplying_numbers/presentation/multiple/fragment/list_fragment/ListTablesViewModel;", "Landroidx/lifecycle/ViewModel;", "getListTablesUseCase", "Lcom/multiplying_numbers/domain/multiple/usecase/GetListTablesUseCase;", "(Lcom/multiplying_numbers/domain/multiple/usecase/GetListTablesUseCase;)V", "_listsTables", "Landroidx/lifecycle/MutableLiveData;", "Lcom/multiplying_numbers/presentation/multiple/fragment/list_fragment/ListTablesViewModel$StateLists;", "listsTables", "Landroidx/lifecycle/LiveData;", "getListsTables", "()Landroidx/lifecycle/LiveData;", "getData", "", "StateLists", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class ListTablesViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.multiplying_numbers.domain.multiple.usecase.GetListTablesUseCase getListTablesUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.multiplying_numbers.presentation.multiple.fragment.list_fragment.ListTablesViewModel.StateLists> _listsTables = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.multiplying_numbers.presentation.multiple.fragment.list_fragment.ListTablesViewModel.StateLists> listsTables = null;
    
    @javax.inject.Inject
    public ListTablesViewModel(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.domain.multiple.usecase.GetListTablesUseCase getListTablesUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.multiplying_numbers.presentation.multiple.fragment.list_fragment.ListTablesViewModel.StateLists> getListsTables() {
        return null;
    }
    
    public final void getData() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/multiplying_numbers/presentation/multiple/fragment/list_fragment/ListTablesViewModel$StateLists;", "", "()V", "Initial", "Result", "Lcom/multiplying_numbers/presentation/multiple/fragment/list_fragment/ListTablesViewModel$StateLists$Initial;", "Lcom/multiplying_numbers/presentation/multiple/fragment/list_fragment/ListTablesViewModel$StateLists$Result;", "app_debug"})
    public static abstract class StateLists {
        
        private StateLists() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/multiplying_numbers/presentation/multiple/fragment/list_fragment/ListTablesViewModel$StateLists$Initial;", "Lcom/multiplying_numbers/presentation/multiple/fragment/list_fragment/ListTablesViewModel$StateLists;", "()V", "app_debug"})
        public static final class Initial extends com.multiplying_numbers.presentation.multiple.fragment.list_fragment.ListTablesViewModel.StateLists {
            @org.jetbrains.annotations.NotNull
            public static final com.multiplying_numbers.presentation.multiple.fragment.list_fragment.ListTablesViewModel.StateLists.Initial INSTANCE = null;
            
            private Initial() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/multiplying_numbers/presentation/multiple/fragment/list_fragment/ListTablesViewModel$StateLists$Result;", "Lcom/multiplying_numbers/presentation/multiple/fragment/list_fragment/ListTablesViewModel$StateLists;", "listsTables", "", "Lcom/multiplying_numbers/domain/multiple/models/ModelTabForCard;", "(Ljava/util/List;)V", "getListsTables", "()Ljava/util/List;", "app_debug"})
        public static final class Result extends com.multiplying_numbers.presentation.multiple.fragment.list_fragment.ListTablesViewModel.StateLists {
            @org.jetbrains.annotations.NotNull
            private final java.util.List<com.multiplying_numbers.domain.multiple.models.ModelTabForCard> listsTables = null;
            
            public Result(@org.jetbrains.annotations.NotNull
            java.util.List<com.multiplying_numbers.domain.multiple.models.ModelTabForCard> listsTables) {
            }
            
            @org.jetbrains.annotations.NotNull
            public final java.util.List<com.multiplying_numbers.domain.multiple.models.ModelTabForCard> getListsTables() {
                return null;
            }
        }
    }
}