package com.multiplying_numbers.presentation.multiple.fragment.singleTabRefactor;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001bH\u0002J\b\u0010\u001f\u001a\u00020\u001bH\u0002J\b\u0010 \u001a\u00020\u001bH\u0002J\b\u0010!\u001a\u00020\u001bH\u0002J\u0012\u0010\"\u001a\u00020\u001b2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J$\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020&2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u00100\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u001dH\u0002J\u0010\u00102\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u001dH\u0002J\u0010\u00103\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u001dH\u0002J\u0010\u00104\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u001dH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017\u00a8\u00065"}, d2 = {"Lcom/multiplying_numbers/presentation/multiple/fragment/singleTabRefactor/FragmentSingleTab;", "Landroidx/fragment/app/Fragment;", "()V", "args", "Lcom/multiplying_numbers/presentation/multiple/fragment/singleTabRefactor/FragmentSingleTabArgs;", "getArgs", "()Lcom/multiplying_numbers/presentation/multiple/fragment/singleTabRefactor/FragmentSingleTabArgs;", "args$delegate", "Landroidx/navigation/NavArgsLazy;", "binding", "Lcom/multiplying_numbers/databinding/FragmentSingleTabBinding;", "checkHistoryUseCase", "Lcom/multiplying_numbers/domain/multiple/usecase/CheckHistoryUseCase;", "getCheckHistoryUseCase", "()Lcom/multiplying_numbers/domain/multiple/usecase/CheckHistoryUseCase;", "setCheckHistoryUseCase", "(Lcom/multiplying_numbers/domain/multiple/usecase/CheckHistoryUseCase;)V", "scopeForQuestions", "Lkotlinx/coroutines/CoroutineScope;", "scopeForWrongAnswer", "singleTabViewModel", "Lcom/multiplying_numbers/presentation/multiple/fragment/singleTabRefactor/SingleTabViewModel;", "getSingleTabViewModel", "()Lcom/multiplying_numbers/presentation/multiple/fragment/singleTabRefactor/SingleTabViewModel;", "singleTabViewModel$delegate", "Lkotlin/Lazy;", "checkHistory", "", "modelSingleTabREFACTOR", "Lcom/multiplying_numbers/domain/multiple/models/ModelSingleTab;", "clickOnBackButton", "clickOnLeftButton", "clickOnRightButton", "observeViewModel", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "openFragmentHistory", "idTable", "", "setModelInRecyclerViewAdapter", "modelSingleTab", "setTextOnLabelWrongAnswer", "setTextOnQuestions", "tesTextOnLeftAndRightButton", "app_debug"})
public final class FragmentSingleTab extends androidx.fragment.app.Fragment {
    @javax.inject.Inject
    public com.multiplying_numbers.domain.multiple.usecase.CheckHistoryUseCase checkHistoryUseCase;
    private com.multiplying_numbers.databinding.FragmentSingleTabBinding binding;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy singleTabViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.navigation.NavArgsLazy args$delegate = null;
    @org.jetbrains.annotations.Nullable
    private kotlinx.coroutines.CoroutineScope scopeForWrongAnswer;
    @org.jetbrains.annotations.Nullable
    private kotlinx.coroutines.CoroutineScope scopeForQuestions;
    
    @javax.inject.Inject
    public FragmentSingleTab() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.multiplying_numbers.domain.multiple.usecase.CheckHistoryUseCase getCheckHistoryUseCase() {
        return null;
    }
    
    public final void setCheckHistoryUseCase(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.domain.multiple.usecase.CheckHistoryUseCase p0) {
    }
    
    private final com.multiplying_numbers.presentation.multiple.fragment.singleTabRefactor.SingleTabViewModel getSingleTabViewModel() {
        return null;
    }
    
    private final com.multiplying_numbers.presentation.multiple.fragment.singleTabRefactor.FragmentSingleTabArgs getArgs() {
        return null;
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * ___OTHER FUN______________________________________________________________________________
     */
    private final void observeViewModel() {
    }
    
    private final void checkHistory(com.multiplying_numbers.domain.multiple.models.ModelSingleTab modelSingleTabREFACTOR) {
    }
    
    private final void openFragmentHistory(int idTable) {
    }
    
    private final void clickOnRightButton() {
    }
    
    private final void clickOnLeftButton() {
    }
    
    private final void setTextOnLabelWrongAnswer(com.multiplying_numbers.domain.multiple.models.ModelSingleTab modelSingleTab) {
    }
    
    private final void tesTextOnLeftAndRightButton(com.multiplying_numbers.domain.multiple.models.ModelSingleTab modelSingleTab) {
    }
    
    private final void setTextOnQuestions(com.multiplying_numbers.domain.multiple.models.ModelSingleTab modelSingleTab) {
    }
    
    private final void setModelInRecyclerViewAdapter(com.multiplying_numbers.domain.multiple.models.ModelSingleTab modelSingleTab) {
    }
    
    private final void clickOnBackButton() {
    }
}