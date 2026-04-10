package com.shihab.mvvmpracticeproject.ui.screen

import androidx.lifecycle.ViewModel
import com.shihab.mvvmpracticeproject.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserViewModel : ViewModel() {

    private val _userState =
        MutableStateFlow(
            User(
                name = "MD. AL-MUHEETU",
                designation = "Android Developer",
                age = 24
            )
        )

    val userState: StateFlow<User> = _userState
    fun updateUserData() {
        _userState.value =
            User(
                name = "MD. AL-MUHEETU Shihab",
                designation = "Student",
                age = 24
            )
    }
}