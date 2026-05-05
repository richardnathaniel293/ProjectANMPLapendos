package com.nmp.habittrackeranmp.data

import android.content.Context
import androidx.core.content.edit
import com.nmp.habittrackeranmp.model.Habit
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HabitRepository(context: Context) {

    private val prefs = context.getSharedPreferences("habit_prefs", Context.MODE_PRIVATE)
    private val gson = Gson()
    private val key = "HABIT_LIST"

    fun getHabits(): MutableList<Habit> {
        val json = prefs.getString(key, null)
        return if (json != null) {
            val type = object : TypeToken<MutableList<Habit>>() {}.type
            gson.fromJson<MutableList<Habit>>(json, type) ?: mutableListOf()
        } else {
            mutableListOf()
        }
    }

    fun saveHabits(list: MutableList<Habit>) {
        val json = gson.toJson(list)
        prefs.edit {
            putString(key, json)
        }
    }

    fun addHabit(habit: Habit) {
        val list = getHabits()
        list.add(habit)
        saveHabits(list)
    }
}