package com.nmp.habittrackeranmp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nmp.habittrackeranmp.data.HabitRepository
import com.nmp.habittrackeranmp.model.Habit

class DashboardViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = HabitRepository(application)

    private val _habitsLD = MutableLiveData<ArrayList<Habit>>()
    val habitsLD: LiveData<ArrayList<Habit>> = _habitsLD

    init {
        loadHabits()
    }

    fun loadHabits() {
        _habitsLD.value = ArrayList(repository.getHabits())
    }

    fun increaseProgress(habitId: Int) {
        val list = repository.getHabits()
        val index = list.indexOfFirst { it.id == habitId }
        if (index == -1) return

        val habit = list[index]
        if (habit.progress >= habit.goal) return

        list[index] = habit.copy(progress = habit.progress + 1)
        repository.saveHabits(list)
        loadHabits()
    }

    fun decreaseProgress(habitId: Int) {
        val list = repository.getHabits()
        val index = list.indexOfFirst { it.id == habitId }
        if (index == -1) return

        val habit = list[index]
        if (habit.progress <= 0) return

        list[index] = habit.copy(progress = habit.progress - 1)
        repository.saveHabits(list)
        loadHabits()
    }
}