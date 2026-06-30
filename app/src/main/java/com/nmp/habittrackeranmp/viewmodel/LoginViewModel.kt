package com.nmp.habittrackeranmp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nmp.habittrackeranmp.model.User
import com.nmp.habittrackeranmp.model.UserDao
import com.nmp.habittrackeranmp.util.buildDb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class LoginViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {

    private val _loginSuccess = MutableLiveData<Boolean>()
    val loginSuccess: LiveData<Boolean> = _loginSuccess

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    fun checkSession() {
        launch {
            val userDao = buildDb(getApplication()).userDao()
            prepareDefaultUser(userDao)

            val user = userDao.selectLoginUser()
            if (user != null) {
                _loginSuccess.postValue(true)
            }
        }
    }

    fun login(username: String, password: String) {
        if (username.isEmpty() || password.isEmpty()) {
            _loginSuccess.value = false
            _errorMessage.value = "Username dan password harus diisi"
            return
        }

        launch {
            val userDao = buildDb(getApplication()).userDao()
            prepareDefaultUser(userDao)

            val user = userDao.selectUser(username, password)
            if (user != null) {
                userDao.logoutAll()
                userDao.login(user.id)
                _errorMessage.postValue(null)
                _loginSuccess.postValue(true)
            } else {
                _loginSuccess.postValue(false)
                _errorMessage.postValue("Username atau password salah")
            }
        }
    }

    private fun prepareDefaultUser(userDao: UserDao) {
        if (userDao.countUser() == 0) {
            userDao.insert(User("student", "123", 0))
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}