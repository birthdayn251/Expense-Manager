package com.example.expenseminiproject.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.expenseminiproject.model.User

class SessionManager(context: Context) {

    private val prefs: SharedPreferences = context.getSharedPreferences("user_session", Context.MODE_PRIVATE)

    companion object {
        private const val USER_ID = "USER_ID"
        private const val USERNAME = "USERNAME"
        private const val PASSWORD = "PASSWORD"
        private const val EMAIL = "EMAIL"
        private const val PHONE = "PHONE"
        private const val IS_LOGGED_IN = "IS_LOGGED_IN"
    }

    fun saveUser(user: User) {
        prefs.edit().apply {
            putInt(USER_ID, user.userId)
            putString(USERNAME, user.username)
            putString(PASSWORD, user.password)
            putString(EMAIL, user.email)
            putString(PHONE, user.phone)
            putBoolean(IS_LOGGED_IN, true)
            apply()
        }
    }

    fun getUser(): User? {
        if (!isLoggedIn()) return null
        val id = prefs.getInt(USER_ID, -1)
        val username = prefs.getString(USERNAME, null)
        val password = prefs.getString(PASSWORD, null)
        val email = prefs.getString(EMAIL, null)
        val phone = prefs.getString(PHONE, null)

        return if (id != -1 && username != null) {
            User(userId = id, username = username, password = password ?: "", email = email ?: "", phone = phone ?: "")
        } else null
    }

    fun isLoggedIn(): Boolean {
        return prefs.getBoolean(IS_LOGGED_IN, false)
    }

    fun clearSession() {
        prefs.edit().clear().apply()
    }
}
