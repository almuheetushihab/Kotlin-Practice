package com.shihab.mvvmpracticeproject.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shihab.mvvmpracticeproject.model.User
import com.shihab.mvvmpracticeproject.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(UserUIState())

    val uiState: StateFlow<UserUIState> = combine(
        userRepository.userFromRoom,
        userRepository.userFromDataStore,
        _uiState
    ) { roomUser,
        dsUser,
        currentState ->
        currentState.copy(
            userFromRoom = roomUser,
            userFromDataStore = dsUser
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = UserUIState()
    )

    fun refreshUserFromServer() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    isLoading = true,
                    errorMessage = null,
                    successMessage = null
                )
            }
            try {
                userRepository.refreshUser()
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        successMessage = "Profile Synced!"
                    )
                }
            } catch (e: Exception) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = e.localizedMessage
                    )
                }
            }
        }
    }

    fun saveOrUpdateUser(user: User) {
        viewModelScope.launch {
            userRepository.saveUser(user)
            _uiState.update { it.copy(successMessage = "User Saved/Updated!") }
        }
    }

    fun deleteUser() {
        viewModelScope.launch {
            userRepository.deleteUser()
            _uiState.update { it.copy(successMessage = "User Deleted!") }
        }
    }

    fun clearMessages() {
        _uiState.update {
            it.copy(
                errorMessage = null,
                successMessage = null
            )
        }
    }
}

data class UserUIState(
    val userFromRoom: User? = null,
    val userFromDataStore: User? = null,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val successMessage: String? = null
)