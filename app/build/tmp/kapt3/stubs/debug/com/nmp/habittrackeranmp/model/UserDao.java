package com.nmp.habittrackeranmp.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\'J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0003H\'J\b\u0010\n\u001a\u00020\u0005H\'J\n\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\'J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\'\u00a8\u0006\u0010"}, d2 = {"Lcom/nmp/habittrackeranmp/model/UserDao;", "", "countUser", "", "insert", "", "user", "Lcom/nmp/habittrackeranmp/model/User;", "login", "id", "logoutAll", "selectLoginUser", "selectUser", "username", "", "password", "app_debug"})
@androidx.room.Dao()
public abstract interface UserDao {
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM `user`")
    public abstract int countUser();
    
    @androidx.room.Query(value = "SELECT * FROM `user` WHERE username = :username AND password = :password LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract com.nmp.habittrackeranmp.model.User selectUser(@org.jetbrains.annotations.NotNull()
    java.lang.String username, @org.jetbrains.annotations.NotNull()
    java.lang.String password);
    
    @androidx.room.Query(value = "SELECT * FROM `user` WHERE is_login = 1 LIMIT 1")
    @org.jetbrains.annotations.Nullable()
    public abstract com.nmp.habittrackeranmp.model.User selectLoginUser();
    
    @androidx.room.Insert(onConflict = 1)
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.nmp.habittrackeranmp.model.User user);
    
    @androidx.room.Query(value = "UPDATE `user` SET is_login = 0")
    public abstract void logoutAll();
    
    @androidx.room.Query(value = "UPDATE `user` SET is_login = 1 WHERE id = :id")
    public abstract void login(int id);
}