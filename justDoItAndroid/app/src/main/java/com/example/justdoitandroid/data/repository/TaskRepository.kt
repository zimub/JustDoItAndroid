package com.example.justdoitandroid.data.repository

import com.example.justdoitandroid.data.model.Task
import com.example.justdoitandroid.network.NetworkManager
import com.example.justdoitandroid.network.NetworkResult
import com.example.justdoitandroid.network.RetrofitClient
import kotlinx.coroutines.delay

object TaskRepository {

    suspend fun getTasks(): NetworkResult<List<Task>> {
        // 真实 API 调用，对接后端时取消注释即可：
        // return NetworkManager.request { RetrofitClient.apiService.getTasks() }

        // Mock：模拟网络延迟与响应
        return try {
            delay(1000)
            NetworkResult.Success(
                listOf(
                    Task(id = 1, title = "完成项目需求文档"),
                    Task(id = 2, title = "Code Review"),
                    Task(id = 3, title = "修复登录页面 Bug"),
                    Task(id = 4, title = "更新依赖库版本"),
                    Task(id = 5, title = "编写单元测试"),
                    Task(id = 6, title = "完成项目需求文档"),
                    Task(id = 7, title = "Code Review"),
                    Task(id = 8, title = "修复登录页面 Bug"),
                    Task(id = 9, title = "更新依赖库版本"),
                    Task(id = 10, title = "编写单元测试"),
                    Task(id = 11, title = "完成项目需求文档"),
                    Task(id = 12, title = "Code Review"),
                    Task(id = 13, title = "修复登录页面 Bug"),
                    Task(id = 14, title = "更新依赖库版本"),
                    Task(id = 15, title = "编写单元测试"),
                    Task(id = 16, title = "完成项目需求文档"),
                    Task(id = 17, title = "Code Review"),
                    Task(id = 18, title = "修复登录页面 Bug"),
                    Task(id = 19, title = "更新依赖库版本"),
                    Task(id = 20, title = "编写单元测试"),
                )
            )
        } catch (e: Exception) {
            NetworkResult.Exception(e)
        }
    }
}
