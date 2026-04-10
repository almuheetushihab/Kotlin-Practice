package com.shihab.mvvmpracticeproject.ui.screen

import androidx.lifecycle.ViewModel
import com.shihab.mvvmpracticeproject.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class UserViewModel : ViewModel() {

    private val _userState = MutableStateFlow(User("Almuheetu Shihab", 24))

    val userState: StateFlow<User> = _userState
    fun updateUserData() {
        _userState.value = User("MD. AL-MUHEETU", 24)
    }
}