package com.nmp.habittrackeranmp.view.adapter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001eBY\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J\u0010\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0006H\u0016J\u0014\u0010\u001b\u001a\u00020\n2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001dR\u001e\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/nmp/habittrackeranmp/view/adapter/HabitListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/nmp/habittrackeranmp/view/adapter/HabitListAdapter$HabitViewHolder;", "Lcom/nmp/habittrackeranmp/view/HabitListener;", "habits", "Ljava/util/ArrayList;", "Lcom/nmp/habittrackeranmp/model/Habit;", "Lkotlin/collections/ArrayList;", "onPlusClick", "Lkotlin/Function1;", "", "onMinusClick", "onTitleClick", "(Ljava/util/ArrayList;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onMinus", "habit", "onPlus", "onTitle", "updateHabitList", "newList", "", "HabitViewHolder", "app_debug"})
public final class HabitListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.nmp.habittrackeranmp.view.adapter.HabitListAdapter.HabitViewHolder> implements com.nmp.habittrackeranmp.view.HabitListener {
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.nmp.habittrackeranmp.model.Habit> habits = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.nmp.habittrackeranmp.model.Habit, kotlin.Unit> onPlusClick = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.nmp.habittrackeranmp.model.Habit, kotlin.Unit> onMinusClick = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.nmp.habittrackeranmp.model.Habit, kotlin.Unit> onTitleClick = null;
    
    public HabitListAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.nmp.habittrackeranmp.model.Habit> habits, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.nmp.habittrackeranmp.model.Habit, kotlin.Unit> onPlusClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.nmp.habittrackeranmp.model.Habit, kotlin.Unit> onMinusClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.nmp.habittrackeranmp.model.Habit, kotlin.Unit> onTitleClick) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.nmp.habittrackeranmp.view.adapter.HabitListAdapter.HabitViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.nmp.habittrackeranmp.view.adapter.HabitListAdapter.HabitViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void updateHabitList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.nmp.habittrackeranmp.model.Habit> newList) {
    }
    
    @java.lang.Override()
    public void onPlus(@org.jetbrains.annotations.NotNull()
    com.nmp.habittrackeranmp.model.Habit habit) {
    }
    
    @java.lang.Override()
    public void onMinus(@org.jetbrains.annotations.NotNull()
    com.nmp.habittrackeranmp.model.Habit habit) {
    }
    
    @java.lang.Override()
    public void onTitle(@org.jetbrains.annotations.NotNull()
    com.nmp.habittrackeranmp.model.Habit habit) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/nmp/habittrackeranmp/view/adapter/HabitListAdapter$HabitViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/nmp/habittrackeranmp/databinding/ItemHabitBinding;", "(Lcom/nmp/habittrackeranmp/databinding/ItemHabitBinding;)V", "getBinding", "()Lcom/nmp/habittrackeranmp/databinding/ItemHabitBinding;", "app_debug"})
    public static final class HabitViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.nmp.habittrackeranmp.databinding.ItemHabitBinding binding = null;
        
        public HabitViewHolder(@org.jetbrains.annotations.NotNull()
        com.nmp.habittrackeranmp.databinding.ItemHabitBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.nmp.habittrackeranmp.databinding.ItemHabitBinding getBinding() {
            return null;
        }
    }
}