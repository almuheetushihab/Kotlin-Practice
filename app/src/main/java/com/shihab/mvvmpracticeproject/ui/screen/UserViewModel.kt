package com.shihab.mvvmpracticeproject.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shihab.mvvmpracticeproject.model.User
import com.shihab.mvvmpracticeproject.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class UIState {
    object Idle : UIState()
    object Loading : UIState()
    data class Success(val message: String) : UIState()
    data class Error(val message: String) : UIState()
}

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UIState>(UIState.Idle)
    val uiState: StateFlow<UIState> = _uiState.asStateFlow()

    val userFromRoom: StateFlow<User?> = userRepository.userFromRoom
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    val userFromDataStore: StateFlow<User?> = userRepository.userFromDataStore
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    fun refreshUserFromServer() {
        viewModelScope.launch {
            _uiState.value = UIState.Loading
            try {
                userRepository.refreshUser()
                _uiState.value = UIState.Success("Data updated successfully!")
            } catch (e: Exception) {
                _uiState.value = UIState.Error(e.localizedMessage ?: "Something went wrong")
            }
        }
    }

    fun saveUserLocally(user: User) {
        viewModelScope.launch {
            userRepository.saveUserToDataStore(user)
        }
    }

    fun resetState() {
        _uiState.value = UIState.Idle
    }
}
