package com.multiplying_numbers.presentation.multiple.fragment.history_fragment_;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0010B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/multiplying_numbers/presentation/multiple/fragment/history_fragment_/HistoryViewModel;", "Landroidx/lifecycle/ViewModel;", "getHistoryFromStorageREFACTOR", "Lcom/multiplying_numbers/domain/multiple/usecase/GetHistoryFromStorage;", "(Lcom/multiplying_numbers/domain/multiple/usecase/GetHistoryFromStorage;)V", "_history", "Landroidx/lifecycle/MutableLiveData;", "Lcom/multiplying_numbers/presentation/multiple/fragment/history_fragment_/HistoryViewModel$StateHistory;", "history", "Landroidx/lifecycle/LiveData;", "getHistory", "()Landroidx/lifecycle/LiveData;", "getHistoryFromStorage", "", "idTable", "", "StateHistory", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class HistoryViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.multiplying_numbers.domain.multiple.usecase.GetHistoryFromStorage getHistoryFromStorageREFACTOR = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.multiplying_numbers.presentation.multiple.fragment.history_fragment_.HistoryViewModel.StateHistory> _history = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.multiplying_numbers.presentation.multiple.fragment.history_fragment_.HistoryViewModel.StateHistory> history = null;
    
    @javax.inject.Inject
    public HistoryViewModel(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.domain.multiple.usecase.GetHistoryFromStorage getHistoryFromStorageREFACTOR) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.multiplying_numbers.presentation.multiple.fragment.history_fragment_.HistoryViewModel.StateHistory> getHistory() {
        return null;
    }
    
    public final void getHistoryFromStorage(int idTable) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/multiplying_numbers/presentation/multiple/fragment/history_fragment_/HistoryViewModel$StateHistory;", "", "()V", "HistoryAnswer", "Initial", "Lcom/multiplying_numbers/presentation/multiple/fragment/history_fragment_/HistoryViewModel$StateHistory$HistoryAnswer;", "Lcom/multiplying_numbers/presentation/multiple/fragment/history_fragment_/HistoryViewModel$StateHistory$Initial;", "app_debug"})
    public static abstract class StateHistory {
        
        private StateHistory() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/multiplying_numbers/presentation/multiple/fragment/history_fragment_/HistoryViewModel$StateHistory$HistoryAnswer;", "Lcom/multiplying_numbers/presentation/multiple/fragment/history_fragment_/HistoryViewModel$StateHistory;", "modelHistory", "Lcom/multiplying_numbers/domain/multiple/models/ModelHistory;", "(Lcom/multiplying_numbers/domain/multiple/models/ModelHistory;)V", "getModelHistory", "()Lcom/multiplying_numbers/domain/multiple/models/ModelHistory;", "app_debug"})
        public static final class HistoryAnswer extends com.multiplying_numbers.presentation.multiple.fragment.history_fragment_.HistoryViewModel.StateHistory {
            @org.jetbrains.annotations.NotNull
            private final com.multiplying_numbers.domain.multiple.models.ModelHistory modelHistory = null;
            
            public HistoryAnswer(@org.jetbrains.annotations.NotNull
            com.multiplying_numbers.domain.multiple.models.ModelHistory modelHistory) {
            }
            
            @org.jetbrains.annotations.NotNull
            public final com.multiplying_numbers.domain.multiple.models.ModelHistory getModelHistory() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/multiplying_numbers/presentation/multiple/fragment/history_fragment_/HistoryViewModel$StateHistory$Initial;", "Lcom/multiplying_numbers/presentation/multiple/fragment/history_fragment_/HistoryViewModel$StateHistory;", "()V", "app_debug"})
        public static final class Initial extends com.multiplying_numbers.presentation.multiple.fragment.history_fragment_.HistoryViewModel.StateHistory {
            @org.jetbrains.annotations.NotNull
            public static final com.multiplying_numbers.presentation.multiple.fragment.history_fragment_.HistoryViewModel.StateHistory.Initial INSTANCE = null;
            
            private Initial() {
            }
        }
    }
}