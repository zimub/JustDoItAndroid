package com.example.justdoitandroid.network

/**
 * 服务端统一响应结构体。
 *
 * 约定格式：
 * {
 *   "code":    200,        // 业务码，200 表示成功
 *   "message": "success", // 业务描述
 *   "data":    { ... }    // 业务数据（可为 null）
 * }
 */
data class ApiResponse<T>(
    val code: Int,
    val message: String,
    val data: T?
)
