package com.example.justdoitandroid.data.repository

import com.example.justdoitandroid.data.model.Task
import kotlinx.coroutines.delay

object TaskRepository {

    /** 模拟网络请求，延迟 1 秒后返回数据 */
    suspend fun getTasks(): List<Task> {
        delay(1000)
        return listOf(
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
    }
}
