package com.shihab.mvvmpracticeproject.repository

import com.shihab.mvvmpracticeproject.api.ApiService
import com.shihab.mvvmpracticeproject.data.local.UserDao
import com.shihab.mvvmpracticeproject.data.local.UserEntity
import com.shihab.mvvmpracticeproject.data.local.UserPreferences
import com.shihab.mvvmpracticeproject.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(
    private val apiService: ApiService,
    private val userDao: UserDao,
    private val userPreferences: UserPreferences
) {

    val userFromRoom: Flow<User?> = userDao.getUser().map { entity ->
        entity?.let {
            User(
                it.name,
                it.designation,
                it.age
            )
        }
    }

    val userFromDataStore: Flow<User?> = userPreferences.userFlow

    suspend fun refreshUser() {
        val user = apiService.getUserProfile()
        userDao.insertUser(
            UserEntity(
                name = user.name,
                designation = user.designation,
                age = user.age
            )
        )
        userPreferences.saveUser(user)
    }

    suspend fun saveUser(user: User) {
        userDao.insertUser(
            UserEntity(
                name = user.name,
                designation = user.designation,
                age = user.age
            )
        )
        userPreferences.saveUser(user)
    }

    suspend fun deleteUser() {
        userDao.deleteUser()
        userPreferences.clearUser()
    }
}
