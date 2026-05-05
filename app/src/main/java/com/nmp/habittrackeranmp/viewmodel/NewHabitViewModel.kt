package com.nmp.habittrackeranmp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nmp.habittrackeranmp.data.HabitRepository
import com.nmp.habittrackeranmp.model.Habit

class NewHabitViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = HabitRepository(application)

    private val _createSuccess = MutableLiveData<Boolean>()
    val createSuccess: LiveData<Boolean> = _createSuccess

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    fun createHabit(
        name: String,
        description: String,
        goal: Int,
        icon: String
    ) {
        if (name.isEmpty() || description.isEmpty() || goal <= 0) {
            _errorMessage.value = "Isi semua field dengan benar"
            return
        }

        val habit = Habit(
            id = System.currentTimeMillis().toInt(),
            icon = icon,
            name = name,
            description = description,
            unit = "times",
            goal = goal,
            progress = 0
        )

        repository.addHabit(habit)

        _errorMessage.value = null
        _createSuccess.value = true
    }
}