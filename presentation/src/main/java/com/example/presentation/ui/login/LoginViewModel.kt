package com.example.presentation.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.util.Patterns

class LoginViewModel : ViewModel() {

    private val _emailError = MutableLiveData<String?>()
    val emailError: LiveData<String?> = _emailError

    private val _passwordError = MutableLiveData<String?>()
    val passwordError: LiveData<String?> = _passwordError

    fun validate(email: String, password: String): Boolean {
        var valid = true

        if (email.isEmpty()) {
            _emailError.value = "Введите email"
            valid = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailError.value = "Неверный формат email"
            valid = false
        } else {
            _emailError.value = null
        }

        if (password.isEmpty()) {
            _passwordError.value = "Введите пароль"
            valid = false
        } else {
            _passwordError.value = null
        }

        return valid
    }
}
