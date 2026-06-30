package com.nmp.habittrackeranmp.util

import android.content.Context
import com.nmp.habittrackeranmp.model.HabitDatabase

val DB_NAME = "habit_db"

fun buildDb(context: Context): HabitDatabase {
    return HabitDatabase.buildDatabase(context)
}