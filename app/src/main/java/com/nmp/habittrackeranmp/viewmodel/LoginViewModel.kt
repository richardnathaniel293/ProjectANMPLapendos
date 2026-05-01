package com.nmp.habittrackeranmp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _loginSuccess = MutableLiveData<Boolean>()
    val loginSuccess: LiveData<Boolean> = _loginSuccess

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    fun login(username: String, password: String) {
        if (username == "student" && password == "123") {
            _errorMessage.value = null
            _loginSuccess.value = true
            return
        }

        _loginSuccess.value = false
        _errorMessage.value = "Username atau password salah"
    }
}