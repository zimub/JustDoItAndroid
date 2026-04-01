package com.example.justdoitandroid.network

import com.example.justdoitandroid.data.model.Task
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    // suspend 代表是挂起函数
    @GET("tasks")
    suspend fun getTasks(): Response<ApiResponse<List<Task>>>
}
