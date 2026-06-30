package com.nmp.habittrackeranmp.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rJ\u000e\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rJ\u0006\u0010\u0016\u001a\u00020\u0013J\b\u0010\u0017\u001a\u00020\u0013H\u0014R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/nmp/habittrackeranmp/viewmodel/DashboardViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "Lkotlinx/coroutines/CoroutineScope;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "habitsLD", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/nmp/habittrackeranmp/model/Habit;", "getHabitsLD", "()Landroidx/lifecycle/MutableLiveData;", "job", "Lkotlinx/coroutines/CompletableJob;", "decreaseProgress", "", "habit", "increaseProgress", "loadHabits", "onCleared", "app_debug"})
public final class DashboardViewModel extends androidx.lifecycle.AndroidViewModel implements kotlinx.coroutines.CoroutineScope {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.nmp.habittrackeranmp.model.Habit>> habitsLD = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CompletableJob job = null;
    
    public DashboardViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.nmp.habittrackeranmp.model.Habit>> getHabitsLD() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    public final void loadHabits() {
    }
    
    public final void increaseProgress(@org.jetbrains.annotations.NotNull()
    com.nmp.habittrackeranmp.model.Habit habit) {
    }
    
    public final void decreaseProgress(@org.jetbrains.annotations.NotNull()
    com.nmp.habittrackeranmp.model.Habit habit) {
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
}