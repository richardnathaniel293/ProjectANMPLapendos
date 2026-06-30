package com.nmp.habittrackeranmp.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface HabitDao {

    @Query("SELECT * FROM habit ORDER BY id ASC")
    fun selectAll(): List<Habit>

    @Query("SELECT * FROM habit WHERE id = :id")
    fun selectById(id: Int): Habit

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg habit: Habit)

    @Update
    fun update(habit: Habit)

    @Delete
    fun delete(habit: Habit)
}