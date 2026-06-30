package com.nmp.habittrackeranmp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "habit")
data class Habit(
    @ColumnInfo(name = "icon")
    var icon: String,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "description")
    var description: String,
    @ColumnInfo(name = "unit")
    var unit: String,
    @ColumnInfo(name = "goal")
    var goal: Int,
    @ColumnInfo(name = "progress")
    var progress: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    @get:Ignore
    val isCompleted: Boolean
        get() = progress >= goal
}