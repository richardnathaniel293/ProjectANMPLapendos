package com.nmp.habittrackeranmp.viewmodel

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nmp.habittrackeranmp.model.Habit
import com.nmp.habittrackeranmp.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class EditHabitViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {

    val name = ObservableField<String>("")
    val description = ObservableField<String>("")
    val goal = ObservableField<String>("")
    val unit = ObservableField<String>("")

    private var currentHabit: Habit? = null

    private val _habitLoaded = MutableLiveData<Habit>()
    val habitLoaded: LiveData<Habit> = _habitLoaded

    private val _updateSuccess = MutableLiveData<Boolean>()
    val updateSuccess: LiveData<Boolean> = _updateSuccess

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    fun loadHabit(id: Int) {
        launch {
            val db = buildDb(getApplication())
            val habit = db.habitDao().selectById(id)
            currentHabit = habit

            withContext(Dispatchers.Main) {
                name.set(habit.name)
                description.set(habit.description)
                goal.set(habit.goal.toString())
                unit.set(habit.unit)
            }

            _habitLoaded.postValue(habit)
        }
    }

    fun updateHabit(selectedIcon: String) {
        val habit = currentHabit
        if (habit == null) {
            _errorMessage.value = "Data habit tidak ditemukan"
            return
        }

        val newName = name.get().orEmpty()
        val newDescription = description.get().orEmpty()
        val newGoal = goal.get()?.toIntOrNull() ?: 0
        val newUnit = unit.get().orEmpty()

        if (newName.isEmpty() || newDescription.isEmpty() || newUnit.isEmpty() || newGoal <= 0) {
            _errorMessage.value = "Isi semua field dengan benar"
            return
        }

        habit.name = newName
        habit.description = newDescription
        habit.goal = newGoal
        habit.unit = newUnit
        if (selectedIcon.isNotEmpty()) {
            habit.icon = selectedIcon
        }

        launch {
            val db = buildDb(getApplication())
            db.habitDao().update(habit)
            _errorMessage.postValue(null)
            _updateSuccess.postValue(true)
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}