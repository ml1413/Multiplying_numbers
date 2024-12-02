package com.multiplying_numbers.presentation.multiple.fragment.list_fragment;

@dagger.hilt.android.AndroidEntryPoint
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J$\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0013H\u0016J\u001a\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u00152\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020\bH\u0002J\u001c\u0010 \u001a\u00020\u00102\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00100\"H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u00a8\u0006#"}, d2 = {"Lcom/multiplying_numbers/presentation/multiple/fragment/list_fragment/FragmentList;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/multiplying_numbers/presentation/multiple/fragment/list_fragment/RecyclerViewListsTables;", "binding", "Lcom/multiplying_numbers/databinding/FragmentListBinding;", "index", "", "listTablesViewModel", "Lcom/multiplying_numbers/presentation/multiple/fragment/list_fragment/ListTablesViewModel;", "getListTablesViewModel", "()Lcom/multiplying_numbers/presentation/multiple/fragment/list_fragment/ListTablesViewModel;", "listTablesViewModel$delegate", "Lkotlin/Lazy;", "observeListTablesViewModel", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onSaveInstanceState", "outState", "onViewCreated", "view", "openSingleTableFragment", "idTable", "setPaddingOnItemRecyclerview", "padding", "Lkotlin/Function1;", "app_debug"})
public final class FragmentList extends androidx.fragment.app.Fragment {
    private com.multiplying_numbers.databinding.FragmentListBinding binding;
    @org.jetbrains.annotations.Nullable
    private com.multiplying_numbers.presentation.multiple.fragment.list_fragment.RecyclerViewListsTables adapter;
    private int index = 0;
    @org.jetbrains.annotations.NotNull
    private final kotlin.Lazy listTablesViewModel$delegate = null;
    
    public FragmentList() {
        super();
    }
    
    private final com.multiplying_numbers.presentation.multiple.fragment.list_fragment.ListTablesViewModel getListTablesViewModel() {
        return null;
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override
    public void onSaveInstanceState(@org.jetbrains.annotations.NotNull
    android.os.Bundle outState) {
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
    
    private final void observeListTablesViewModel() {
    }
    
    /**
     * other fun ____________________________________________________________________________________
     */
    private final void openSingleTableFragment(int idTable) {
    }
    
    private final void setPaddingOnItemRecyclerview(kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> padding) {
    }
}