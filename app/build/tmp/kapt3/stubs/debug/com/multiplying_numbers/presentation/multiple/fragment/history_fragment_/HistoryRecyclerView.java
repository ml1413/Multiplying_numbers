package com.multiplying_numbers.presentation.multiple.fragment.history_fragment_;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/multiplying_numbers/presentation/multiple/fragment/history_fragment_/HistoryRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/multiplying_numbers/presentation/multiple/fragment/history_fragment_/HistoryRecyclerView$HistoryHolder;", "modelHistory", "Lcom/multiplying_numbers/domain/multiple/models/ModelHistory;", "(Lcom/multiplying_numbers/domain/multiple/models/ModelHistory;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "HistoryHolder", "app_debug"})
public final class HistoryRecyclerView extends androidx.recyclerview.widget.RecyclerView.Adapter<com.multiplying_numbers.presentation.multiple.fragment.history_fragment_.HistoryRecyclerView.HistoryHolder> {
    @org.jetbrains.annotations.NotNull
    private final com.multiplying_numbers.domain.multiple.models.ModelHistory modelHistory = null;
    
    public HistoryRecyclerView(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.domain.multiple.models.ModelHistory modelHistory) {
        super();
    }
    
    @java.lang.Override
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public com.multiplying_numbers.presentation.multiple.fragment.history_fragment_.HistoryRecyclerView.HistoryHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull
    com.multiplying_numbers.presentation.multiple.fragment.history_fragment_.HistoryRecyclerView.HistoryHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0002J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/multiplying_numbers/presentation/multiple/fragment/history_fragment_/HistoryRecyclerView$HistoryHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "binding", "Lcom/multiplying_numbers/databinding/ItemResultAnswerRefactorBinding;", "formatDate", "", "kotlin.jvm.PlatformType", "time", "", "getListIncludeView", "", "Lcom/multiplying_numbers/databinding/IncludeTvAnswerItemForResultBinding;", "initView", "", "modelHistory", "Lcom/multiplying_numbers/domain/multiple/models/ItemHistory;", "setAnswer", "modelQuestions", "Lcom/multiplying_numbers/domain/multiple/models/ModelQuestions;", "include", "setLabel", "setQuestion", "app_debug"})
    public static final class HistoryHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull
        private final android.view.View view = null;
        @org.jetbrains.annotations.NotNull
        private final com.multiplying_numbers.databinding.ItemResultAnswerRefactorBinding binding = null;
        
        public HistoryHolder(@org.jetbrains.annotations.NotNull
        android.view.View view) {
            super(null);
        }
        
        public final void initView(@org.jetbrains.annotations.NotNull
        com.multiplying_numbers.domain.multiple.models.ItemHistory modelHistory) {
        }
        
        /**
         * otherfun _____________________________________________________________________________
         */
        private final void setQuestion(com.multiplying_numbers.domain.multiple.models.ModelQuestions modelQuestions, com.multiplying_numbers.databinding.IncludeTvAnswerItemForResultBinding include) {
        }
        
        private final void setAnswer(com.multiplying_numbers.domain.multiple.models.ModelQuestions modelQuestions, com.multiplying_numbers.databinding.IncludeTvAnswerItemForResultBinding include) {
        }
        
        private final void setLabel(com.multiplying_numbers.domain.multiple.models.ItemHistory modelHistory) {
        }
        
        private final java.util.List<com.multiplying_numbers.databinding.IncludeTvAnswerItemForResultBinding> getListIncludeView(com.multiplying_numbers.databinding.ItemResultAnswerRefactorBinding binding) {
            return null;
        }
        
        private final java.lang.String formatDate(long time) {
            return null;
        }
    }
}