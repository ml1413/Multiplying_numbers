package com.multiplying_numbers.presentation.multiple.fragment.singleTabRefactor;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001#B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0006\u0010\u0016\u001a\u00020\u0013J\u0006\u0010\u0017\u001a\u00020\u0013J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\u000e\u0010\u0010\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0013JX\u0010\u001c\u001a\u00020\u0013*\u00020\r2\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\u001e2\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00130 2\u0014\b\u0002\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00130 2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130\u001eH\u0002R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006$"}, d2 = {"Lcom/multiplying_numbers/presentation/multiple/fragment/singleTabRefactor/SingleTabViewModel;", "Landroidx/lifecycle/ViewModel;", "getSingleTableUseCase", "Lcom/multiplying_numbers/domain/multiple/usecase/GetSingleTableUseCase;", "checkLeftAnswerUseCase", "Lcom/multiplying_numbers/domain/multiple/usecase/CheckLeftAnswerUseCase;", "checkRightAnswerUseCase", "Lcom/multiplying_numbers/domain/multiple/usecase/CheckRightAnswerUseCase;", "saveInStorageUseCase", "Lcom/multiplying_numbers/domain/multiple/usecase/SaveInStorageUseCase;", "(Lcom/multiplying_numbers/domain/multiple/usecase/GetSingleTableUseCase;Lcom/multiplying_numbers/domain/multiple/usecase/CheckLeftAnswerUseCase;Lcom/multiplying_numbers/domain/multiple/usecase/CheckRightAnswerUseCase;Lcom/multiplying_numbers/domain/multiple/usecase/SaveInStorageUseCase;)V", "_table", "Landroidx/lifecycle/MutableLiveData;", "Lcom/multiplying_numbers/presentation/multiple/fragment/singleTabRefactor/SingleTabViewModel$StateTable;", "table", "Landroidx/lifecycle/LiveData;", "getTable", "()Landroidx/lifecycle/LiveData;", "checkAnswer", "", "newModel", "Lcom/multiplying_numbers/domain/multiple/models/ModelSingleTab;", "checkLeftAnswer", "checkRightAnswer", "checkVictory", "idTable", "", "saveInStorage", "checkState", "onInitial", "Lkotlin/Function0;", "onResumeGame", "Lkotlin/Function1;", "onVictory", "onDisableButton", "StateTable", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel
public final class SingleTabViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.multiplying_numbers.domain.multiple.usecase.GetSingleTableUseCase getSingleTableUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final com.multiplying_numbers.domain.multiple.usecase.CheckLeftAnswerUseCase checkLeftAnswerUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final com.multiplying_numbers.domain.multiple.usecase.CheckRightAnswerUseCase checkRightAnswerUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final com.multiplying_numbers.domain.multiple.usecase.SaveInStorageUseCase saveInStorageUseCase = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.multiplying_numbers.presentation.multiple.fragment.singleTabRefactor.SingleTabViewModel.StateTable> _table = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.multiplying_numbers.presentation.multiple.fragment.singleTabRefactor.SingleTabViewModel.StateTable> table = null;
    
    @javax.inject.Inject
    public SingleTabViewModel(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.domain.multiple.usecase.GetSingleTableUseCase getSingleTableUseCase, @org.jetbrains.annotations.NotNull
    com.multiplying_numbers.domain.multiple.usecase.CheckLeftAnswerUseCase checkLeftAnswerUseCase, @org.jetbrains.annotations.NotNull
    com.multiplying_numbers.domain.multiple.usecase.CheckRightAnswerUseCase checkRightAnswerUseCase, @org.jetbrains.annotations.NotNull
    com.multiplying_numbers.domain.multiple.usecase.SaveInStorageUseCase saveInStorageUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.multiplying_numbers.presentation.multiple.fragment.singleTabRefactor.SingleTabViewModel.StateTable> getTable() {
        return null;
    }
    
    public final void getTable(int idTable) {
    }
    
    public final void checkLeftAnswer() {
    }
    
    public final void checkRightAnswer() {
    }
    
    public final void saveInStorage() {
    }
    
    /**
     * otherFun__________________________________________________________________________________
     */
    private final void checkState(com.multiplying_numbers.presentation.multiple.fragment.singleTabRefactor.SingleTabViewModel.StateTable $this$checkState, kotlin.jvm.functions.Function0<kotlin.Unit> onInitial, kotlin.jvm.functions.Function1<? super com.multiplying_numbers.domain.multiple.models.ModelSingleTab, kotlin.Unit> onResumeGame, kotlin.jvm.functions.Function1<? super com.multiplying_numbers.domain.multiple.models.ModelSingleTab, kotlin.Unit> onVictory, kotlin.jvm.functions.Function0<kotlin.Unit> onDisableButton) {
    }
    
    private final void checkAnswer(com.multiplying_numbers.domain.multiple.models.ModelSingleTab newModel) {
    }
    
    private final void checkVictory() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/multiplying_numbers/presentation/multiple/fragment/singleTabRefactor/SingleTabViewModel$StateTable;", "", "()V", "DisableButton", "Initial", "ResumeGame", "Victory", "Lcom/multiplying_numbers/presentation/multiple/fragment/singleTabRefactor/SingleTabViewModel$StateTable$DisableButton;", "Lcom/multiplying_numbers/presentation/multiple/fragment/singleTabRefactor/SingleTabViewModel$StateTable$Initial;", "Lcom/multiplying_numbers/presentation/multiple/fragment/singleTabRefactor/SingleTabViewModel$StateTable$ResumeGame;", "Lcom/multiplying_numbers/presentation/multiple/fragment/singleTabRefactor/SingleTabViewModel$StateTable$Victory;", "app_debug"})
    public static abstract class StateTable {
        
        private StateTable() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/multiplying_numbers/presentation/multiple/fragment/singleTabRefactor/SingleTabViewModel$StateTable$DisableButton;", "Lcom/multiplying_numbers/presentation/multiple/fragment/singleTabRefactor/SingleTabViewModel$StateTable;", "()V", "app_debug"})
        public static final class DisableButton extends com.multiplying_numbers.presentation.multiple.fragment.singleTabRefactor.SingleTabViewModel.StateTable {
            @org.jetbrains.annotations.NotNull
            public static final com.multiplying_numbers.presentation.multiple.fragment.singleTabRefactor.SingleTabViewModel.StateTable.DisableButton INSTANCE = null;
            
            private DisableButton() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/multiplying_numbers/presentation/multiple/fragment/singleTabRefactor/SingleTabViewModel$StateTable$Initial;", "Lcom/multiplying_numbers/presentation/multiple/fragment/singleTabRefactor/SingleTabViewModel$StateTable;", "()V", "app_debug"})
        public static final class Initial extends com.multiplying_numbers.presentation.multiple.fragment.singleTabRefactor.SingleTabViewModel.StateTable {
            @org.jetbrains.annotations.NotNull
            public static final com.multiplying_numbers.presentation.multiple.fragment.singleTabRefactor.SingleTabViewModel.StateTable.Initial INSTANCE = null;
            
            private Initial() {
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/multiplying_numbers/presentation/multiple/fragment/singleTabRefactor/SingleTabViewModel$StateTable$ResumeGame;", "Lcom/multiplying_numbers/presentation/multiple/fragment/singleTabRefactor/SingleTabViewModel$StateTable;", "modelSingleTab", "Lcom/multiplying_numbers/domain/multiple/models/ModelSingleTab;", "(Lcom/multiplying_numbers/domain/multiple/models/ModelSingleTab;)V", "getModelSingleTab", "()Lcom/multiplying_numbers/domain/multiple/models/ModelSingleTab;", "app_debug"})
        public static final class ResumeGame extends com.multiplying_numbers.presentation.multiple.fragment.singleTabRefactor.SingleTabViewModel.StateTable {
            @org.jetbrains.annotations.NotNull
            private final com.multiplying_numbers.domain.multiple.models.ModelSingleTab modelSingleTab = null;
            
            public ResumeGame(@org.jetbrains.annotations.NotNull
            com.multiplying_numbers.domain.multiple.models.ModelSingleTab modelSingleTab) {
            }
            
            @org.jetbrains.annotations.NotNull
            public final com.multiplying_numbers.domain.multiple.models.ModelSingleTab getModelSingleTab() {
                return null;
            }
        }
        
        @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/multiplying_numbers/presentation/multiple/fragment/singleTabRefactor/SingleTabViewModel$StateTable$Victory;", "Lcom/multiplying_numbers/presentation/multiple/fragment/singleTabRefactor/SingleTabViewModel$StateTable;", "modelSingleTab", "Lcom/multiplying_numbers/domain/multiple/models/ModelSingleTab;", "(Lcom/multiplying_numbers/domain/multiple/models/ModelSingleTab;)V", "getModelSingleTab", "()Lcom/multiplying_numbers/domain/multiple/models/ModelSingleTab;", "app_debug"})
        public static final class Victory extends com.multiplying_numbers.presentation.multiple.fragment.singleTabRefactor.SingleTabViewModel.StateTable {
            @org.jetbrains.annotations.NotNull
            private final com.multiplying_numbers.domain.multiple.models.ModelSingleTab modelSingleTab = null;
            
            public Victory(@org.jetbrains.annotations.NotNull
            com.multiplying_numbers.domain.multiple.models.ModelSingleTab modelSingleTab) {
            }
            
            @org.jetbrains.annotations.NotNull
            public final com.multiplying_numbers.domain.multiple.models.ModelSingleTab getModelSingleTab() {
                return null;
            }
        }
    }
}