package com.example.justdoitandroid.network

/**
 * 网络请求结果的统一封装，区分三类错误来源：
 *
 * - [Success]       请求成功，持有业务数据
 * - [BusinessError] HTTP 成功但业务码非 200（如登录失效、权限不足）
 * - [HttpError]     HTTP 层错误（4xx / 5xx）
 * - [Exception]     网络异常（无网络、超时、解析失败等）
 */
sealed class NetworkResult<out T> {
    data class Success<out T>(val data: T) : NetworkResult<T>()
    data class BusinessError(val code: Int, val message: String) : NetworkResult<Nothing>()
    data class HttpError(val code: Int, val message: String) : NetworkResult<Nothing>()
    data class Exception(val throwable: Throwable) : NetworkResult<Nothing>()
}
