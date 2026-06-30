package com.nmp.habittrackeranmp.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT COUNT(*) FROM `user`")
    fun countUser(): Int

    @Query("SELECT * FROM `user` WHERE username = :username AND password = :password LIMIT 1")
    fun selectUser(username: String, password: String): User?

    @Query("SELECT * FROM `user` WHERE is_login = 1 LIMIT 1")
    fun selectLoginUser(): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: User)

    @Query("UPDATE `user` SET is_login = 0")
    fun logoutAll()

    @Query("UPDATE `user` SET is_login = 1 WHERE id = :id")
    fun login(id: Int)
}