package com.example.expenseminiproject.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.expenseminiproject.SingleLiveEvent
import com.example.expenseminiproject.database.reposity.UserRepository
import com.example.expenseminiproject.model.User
import com.example.expenseminiproject.utils.SessionManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(application: Application, private val userRepository: UserRepository) : AndroidViewModel(application) {
    var mLoginResult = SingleLiveEvent<Int>()
    var mRegisterResult = SingleLiveEvent<Int>()

    val mSessionManager: SessionManager = SessionManager(application)

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {

            }

        }
    }

    override fun onCleared() {
        super.onCleared()
        //viewModelJob.cancel()
    }

    class MainViewModelFactory(
        private val application: Application,
        private val userRepository: UserRepository
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
                return MainViewModel(application, userRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

    fun handleLogin(username: String, password: String) {
        viewModelScope.launch {
            try {
                val user = userRepository.login(username, password)
                if (user != null) {
                    mSessionManager.saveUser(user)  // Lưu thông tin nếu thành công
                    mLoginResult.value = 1 // thành công
                } else {
                    mLoginResult.value = 0 // sai thông tin
                }
            } catch (e: Exception) {
                mLoginResult.value = -1 // lỗi hệ thống
            }
        }
    }

    fun handleRegister(username: String, password: String) {
        viewModelScope.launch {
            try {
                mRegisterResult.value = userRepository.insertUser(User(username = username, password = password)).toInt()

            } catch (e: Exception) {
                mRegisterResult.value = -1 // lỗi hệ thống
            }
        }
    }

}