package com.nmp.habittrackeranmp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nmp.habittrackeranmp.model.Habit

class DashboardViewModel : ViewModel() {

    private data class HabitTemplate(
        val icon: String,
        val name: String,
        val description: String,
        val unit: String,
        val goal: Int,
        val initialProgress: Int
    )

    private val templates = listOf(
        HabitTemplate(
            icon = "\uD83D\uDCA7",
            name = "Drink Water",
            description = "Stay hydrated throughout the day",
            unit = "glasses",
            goal = 8,
            initialProgress = 3
        ),
        HabitTemplate(
            icon = "\uD83D\uDCAA",
            name = "Exercise",
            description = "Daily workout routine",
            unit = "minutes",
            goal = 30,
            initialProgress = 15
        ),
        HabitTemplate(
            icon = "\uD83D\uDCDA",
            name = "Read Books",
            description = "Expand your knowledge",
            unit = "pages",
            goal = 20,
            initialProgress = 20
        ),
        HabitTemplate(
            icon = "\uD83E\uDDD8",
            name = "Meditation",
            description = "Mindfulness practice",
            unit = "minutes",
            goal = 10,
            initialProgress = 0
        )
    )

    private val _habitsLD = MutableLiveData<ArrayList<Habit>>(arrayListOf())
    val habitsLD: LiveData<ArrayList<Habit>> = _habitsLD

    private var nextId = 1
    private var templateIndex = 0

    fun addHabitFromFab() {
        val template = templates[templateIndex % templates.size]
        templateIndex += 1

        val updated = ArrayList(_habitsLD.value ?: arrayListOf())
        updated.add(
            Habit(
                id = nextId++,
                icon = template.icon,
                name = template.name,
                description = template.description,
                unit = template.unit,
                goal = template.goal,
                progress = template.initialProgress
            )
        )
        _habitsLD.value = updated
    }

    fun increaseProgress(habitId: Int) {
        val currentList = _habitsLD.value ?: return
        val index = currentList.indexOfFirst { it.id == habitId }
        if (index == -1) return

        val habit = currentList[index]
        if (habit.progress >= habit.goal) return

        val updated = ArrayList(currentList)
        updated[index] = habit.copy(progress = habit.progress + 1)
        _habitsLD.value = updated
    }

    fun decreaseProgress(habitId: Int) {
        val currentList = _habitsLD.value ?: return
        val index = currentList.indexOfFirst { it.id == habitId }
        if (index == -1) return

        val habit = currentList[index]
        if (habit.progress <= 0) return

        val updated = ArrayList(currentList)
        updated[index] = habit.copy(progress = habit.progress - 1)
        _habitsLD.value = updated
    }
}