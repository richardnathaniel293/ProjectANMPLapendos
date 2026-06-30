package com.nmp.habittrackeranmp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.nmp.habittrackeranmp.model.Habit
import com.nmp.habittrackeranmp.util.buildDb
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

class DashboardViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {

    val habitsLD = MutableLiveData<List<Habit>>()

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    fun loadHabits() {
        launch {
            val db = buildDb(getApplication())
            habitsLD.postValue(db.habitDao().selectAll())
        }
    }

    fun increaseProgress(habit: Habit) {
        launch {
            val db = buildDb(getApplication())
            if (habit.progress < habit.goal) {
                habit.progress += 1
                db.habitDao().update(habit)
            }
            habitsLD.postValue(db.habitDao().selectAll())
        }
    }

    fun decreaseProgress(habit: Habit) {
        launch {
            val db = buildDb(getApplication())
            if (habit.progress > 0) {
                habit.progress -= 1
                db.habitDao().update(habit)
            }
            habitsLD.postValue(db.habitDao().selectAll())
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}