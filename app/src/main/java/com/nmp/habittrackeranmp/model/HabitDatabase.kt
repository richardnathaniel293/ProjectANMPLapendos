package com.nmp.habittrackeranmp.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nmp.habittrackeranmp.util.DB_NAME
import com.nmp.habittrackeranmp.util.MIGRATION_1_2

@Database(entities = [Habit::class, User::class], version = 2, exportSchema = false)
abstract class HabitDatabase : RoomDatabase() {

    abstract fun habitDao(): HabitDao
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var instance: HabitDatabase? = null
        private val LOCK = Any()

        fun buildDatabase(context: Context): HabitDatabase {
            return instance ?: synchronized(LOCK) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    HabitDatabase::class.java,
                    DB_NAME
                )
                    .addMigrations(MIGRATION_1_2)
                    .build()
                    .also { instance = it }
            }
        }
    }
}