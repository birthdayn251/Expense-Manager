package com.example.expenseminiproject.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.expenseminiproject.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(user: User): Long

    @Query("SELECT * FROM User WHERE username = :username AND password = :password")
    suspend fun login(username: String, password: String): User?

    @Query("SELECT * FROM User WHERE username = :username")
    suspend fun getUser(username: String): User?

    @Query("SELECT * FROM User")
    suspend fun getAllUsers(): List<User>
}
