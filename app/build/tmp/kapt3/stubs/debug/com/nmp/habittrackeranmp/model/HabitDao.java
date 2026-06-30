package com.nmp.habittrackeranmp.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J!\u0010\u0006\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0007\"\u00020\u0005H\'\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\'J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\'J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\u000f"}, d2 = {"Lcom/nmp/habittrackeranmp/model/HabitDao;", "", "delete", "", "habit", "Lcom/nmp/habittrackeranmp/model/Habit;", "insert", "", "([Lcom/nmp/habittrackeranmp/model/Habit;)V", "selectAll", "", "selectById", "id", "", "update", "app_debug"})
@androidx.room.Dao()
public abstract interface HabitDao {
    
    @androidx.room.Query(value = "SELECT * FROM habit ORDER BY id ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.nmp.habittrackeranmp.model.Habit> selectAll();
    
    @androidx.room.Query(value = "SELECT * FROM habit WHERE id = :id")
    @org.jetbrains.annotations.NotNull()
    public abstract com.nmp.habittrackeranmp.model.Habit selectById(int id);
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.nmp.habittrackeranmp.model.Habit... habit);
    
    @androidx.room.Update()
    public abstract void update(@org.jetbrains.annotations.NotNull()
    com.nmp.habittrackeranmp.model.Habit habit);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.nmp.habittrackeranmp.model.Habit habit);
}