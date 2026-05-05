package com.nmp.habittrackeranmp.data

import android.content.Context
import com.nmp.habittrackeranmp.model.Habit
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class HabitRepository(context: Context) {

    private val prefs = context.getSharedPreferences("habit_prefs", Context.MODE_PRIVATE)
    private val gson = Gson()
    private val KEY = "HABIT_LIST"

    fun getHabits(): MutableList<Habit> {
        val json = prefs.getString(KEY, null)
        return if (json != null) {
            val type = object : TypeToken<MutableList<Habit>>() {}.type
            // Tambahkan ?: mutableListOf() di akhir untuk mencegah error nullability
            gson.fromJson<MutableList<Habit>>(json, type) ?: mutableListOf()
        } else {
            mutableListOf()
        }
    }

    fun saveHabits(list: MutableList<Habit>) {
        val json = gson.toJson(list)
        prefs.edit().putString(KEY, json).apply()
    }

    fun addHabit(habit: Habit) {
        val list = getHabits()
        list.add(habit)
        saveHabits(list)
    }

    fun updateHabit(index: Int, habit: Habit) {
        val list = getHabits()
        if (index in list.indices) { // Tambahkan pengecekan index agar aman
            list[index] = habit
            saveHabits(list)
        }
    }

    fun deleteHabit(index: Int) {
        val list = getHabits()
        if (index in list.indices) { // Tambahkan pengecekan index agar aman
            list.removeAt(index)
            saveHabits(list)
        }
    }
}