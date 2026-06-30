package com.nmp.habittrackeranmp.view

import com.nmp.habittrackeranmp.model.Habit

interface HabitListener {
    fun onPlus(habit: Habit)
    fun onMinus(habit: Habit)
    fun onTitle(habit: Habit)
}