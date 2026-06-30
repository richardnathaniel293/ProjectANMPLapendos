package com.nmp.habittrackeranmp.view;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\b"}, d2 = {"Lcom/nmp/habittrackeranmp/view/HabitListener;", "", "onMinus", "", "habit", "Lcom/nmp/habittrackeranmp/model/Habit;", "onPlus", "onTitle", "app_debug"})
public abstract interface HabitListener {
    
    public abstract void onPlus(@org.jetbrains.annotations.NotNull()
    com.nmp.habittrackeranmp.model.Habit habit);
    
    public abstract void onMinus(@org.jetbrains.annotations.NotNull()
    com.nmp.habittrackeranmp.model.Habit habit);
    
    public abstract void onTitle(@org.jetbrains.annotations.NotNull()
    com.nmp.habittrackeranmp.model.Habit habit);
}