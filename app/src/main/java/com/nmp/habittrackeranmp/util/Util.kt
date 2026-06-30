package com.nmp.habittrackeranmp.util

import android.content.Context
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.nmp.habittrackeranmp.model.HabitDatabase

val DB_NAME = "habit_db"

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "CREATE TABLE IF NOT EXISTS `user` " +
                "(`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                "`username` TEXT NOT NULL, " +
                "`password` TEXT NOT NULL, " +
                "`is_login` INTEGER NOT NULL)"
        )
    }
}

fun buildDb(context: Context): HabitDatabase {
    return HabitDatabase.buildDatabase(context)
}