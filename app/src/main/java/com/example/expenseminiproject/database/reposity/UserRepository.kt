package com.example.expenseminiproject.database.reposity

import android.app.Application
import com.example.expenseminiproject.database.AppDatabase
import com.example.expenseminiproject.database.dao.UserDao
import com.example.expenseminiproject.model.User

class UserRepository(private val userDao: UserDao) {
    suspend fun getAllUsers(): List<User> = userDao.getAllUsers()
    suspend fun insertUser(user: User): Long = userDao.insert(user)

    suspend fun login(username: String, password: String) = userDao.login(username = username, password = password)

    companion object {
        @Volatile
        private var INSTANCE: UserRepository? = null

        fun getInstance(application: Application): UserRepository {
            return INSTANCE ?: synchronized(this) {
                val database = AppDatabase.getDatabase(application)
                val instance = UserRepository(database.userDao())
                INSTANCE = instance
                instance
            }
        }
    }

}