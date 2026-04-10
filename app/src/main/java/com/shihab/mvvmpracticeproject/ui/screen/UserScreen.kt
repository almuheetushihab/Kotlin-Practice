package com.shihab.mvvmpracticeproject.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.shihab.mvvmpracticeproject.model.User

@Composable
fun UserScreen(
    viewModel: UserViewModel = hiltViewModel()
) {
    val userFromRoom by viewModel.userFromRoom.collectAsState()
    val userFromDataStore by viewModel.userFromDataStore.collectAsState()
    val uiState by viewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(uiState) {
        if (uiState is UIState.Success) {
            snackbarHostState.showSnackbar((uiState as UIState.Success).message)
            viewModel.resetState()
        } else if (uiState is UIState.Error) {
            snackbarHostState.showSnackbar((uiState as UIState.Error).message)
            viewModel.resetState()
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "User Profile (MVVM + Clean)",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Display Data from Room
            UserCard(title = "From Room Database", user = userFromRoom)

            Spacer(modifier = Modifier.height(16.dp))

            // Display Data from DataStore
            UserCard(title = "From DataStore", user = userFromDataStore)

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { viewModel.refreshUserFromServer() },
                modifier = Modifier.fillMaxWidth(),
                enabled = uiState !is UIState.Loading
            ) {
                if (uiState is UIState.Loading) {
                    CircularProgressIndicator(
                        modifier = Modifier.padding(end = 8.dp),
                        color = MaterialTheme.colorScheme.onPrimary,
                        strokeWidth = 2.dp
                    )
                }
                Text("Refresh from Server (Mock)")
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {
                    viewModel.saveUserLocally(
                        User("Shihab", "Android Engineer", 24)
                    )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Save Manual Data to DataStore")
            }
        }
    }
}

@Composable
fun UserCard(title: String, user: User?) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            if (user != null) {
                Text(
                    text = "Name: ${user.name}",
                    fontSize = 18.sp
                )
                Text(
                    text = "Designation: ${user.designation}",
                    fontSize = 16.sp
                )
                Text(
                    text = "Age: ${user.age}",
                    fontSize = 16.sp
                )
            } else {
                Text(
                    text = "No data found",
                    color = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}
