package com.multiplying_numbers.presentation.multiple.fragment.singleTabRefactor;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/multiplying_numbers/presentation/multiple/fragment/singleTabRefactor/RecyclerViewSingleTab;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/multiplying_numbers/presentation/multiple/fragment/singleTabRefactor/RecyclerViewSingleTab$TableHolderREFACTOR;", "modelSingleTab", "Lcom/multiplying_numbers/domain/multiple/models/ModelSingleTab;", "(Lcom/multiplying_numbers/domain/multiple/models/ModelSingleTab;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "TableHolderREFACTOR", "app_debug"})
public final class RecyclerViewSingleTab extends androidx.recyclerview.widget.RecyclerView.Adapter<com.multiplying_numbers.presentation.multiple.fragment.singleTabRefactor.RecyclerViewSingleTab.TableHolderREFACTOR> {
    @org.jetbrains.annotations.NotNull
    private final com.multiplying_numbers.domain.multiple.models.ModelSingleTab modelSingleTab = null;
    
    public RecyclerViewSingleTab(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.domain.multiple.models.ModelSingleTab modelSingleTab) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.multiplying_numbers.presentation.multiple.fragment.singleTabRefactor.RecyclerViewSingleTab.TableHolderREFACTOR onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.presentation.multiple.fragment.singleTabRefactor.RecyclerViewSingleTab.TableHolderREFACTOR holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/multiplying_numbers/presentation/multiple/fragment/singleTabRefactor/RecyclerViewSingleTab$TableHolderREFACTOR;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "binding", "Lcom/multiplying_numbers/databinding/ItemForTableRvBinding;", "initView", "", "modelSingleTabREFACTOR", "Lcom/multiplying_numbers/domain/multiple/models/ModelQuestions;", "app_debug"})
    public static final class TableHolderREFACTOR extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.view.View view = null;
        @org.jetbrains.annotations.NotNull
        private final com.multiplying_numbers.databinding.ItemForTableRvBinding binding = null;
        
        public TableHolderREFACTOR(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        public final void initView(@org.jetbrains.annotations.NotNull
        com.multiplying_numbers.domain.multiple.models.ModelQuestions modelSingleTabREFACTOR) {
        }
    }
}