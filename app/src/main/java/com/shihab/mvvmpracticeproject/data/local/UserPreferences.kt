package com.shihab.mvvmpracticeproject.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.shihab.mvvmpracticeproject.model.User
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_prefs")

@Singleton
class UserPreferences @Inject constructor(@ApplicationContext private val context: Context) {

    companion object {
        val NAME = stringPreferencesKey("user_name")
        val DESIGNATION = stringPreferencesKey("user_designation")
        val AGE = intPreferencesKey("user_age")
    }

    val userFlow: Flow<User?> = context.dataStore.data.map { preferences ->
        val name = preferences[NAME]
        val designation = preferences[DESIGNATION]
        val age = preferences[AGE]

        if (name != null && designation != null && age != null) {
            User(name, designation, age)
        } else {
            null
        }
    }

    suspend fun saveUser(user: User) {
        context.dataStore.edit { preferences ->
            preferences[NAME] = user.name
            preferences[DESIGNATION] = user.designation
            preferences[AGE] = user.age
        }
    }
}
