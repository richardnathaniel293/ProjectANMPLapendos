package com.nmp.habittrackeranmp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nmp.habittrackeranmp.model.Habit
import com.nmp.habittrackeranmp.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class NewHabitViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {

    private val _createSuccess = MutableLiveData<Boolean>()
    val createSuccess: LiveData<Boolean> = _createSuccess

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    fun createHabit(
        name: String,
        description: String,
        goal: Int,
        unit: String,
        icon: String
    ) {
        if (name.isEmpty() || description.isEmpty() || goal <= 0) {
            _errorMessage.value = "Isi semua field dengan benar"
            return
        }

        val habit = Habit(
            icon = icon,
            name = name,
            description = description,
            unit = unit,
            goal = goal,
            progress = 0
        )

        launch {
            val db = buildDb(getApplication())
            db.habitDao().insert(habit)
            _errorMessage.postValue(null)
            _createSuccess.postValue(true)
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}
