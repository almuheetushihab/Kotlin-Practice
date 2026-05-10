package com.shihab.mvvmpracticeproject.api

import com.shihab.mvvmpracticeproject.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("user/profile")
    suspend fun getUserProfile(): User
}
