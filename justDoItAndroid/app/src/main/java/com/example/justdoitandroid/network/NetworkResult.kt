package com.example.justdoitandroid.network

/**
 * 网络请求结果的统一封装。
 *
 * - [Success]          请求成功，持有业务数据
 * - [Error.Business]   HTTP 成功但业务码非 200（如登录失效、权限不足）
 * - [Error.Http]       HTTP 层错误（4xx / 5xx）
 * - [Error.Network]    网络异常（无网络、超时、解析失败等）
 *
 * 调用方可以用 `is NetworkResult.Error` 统一兜底，
 * 也可以细分到 `is NetworkResult.Error.Business` 等子类型单独处理。
 */
sealed class NetworkResult<out T> {
    data class Success<out T>(val data: T) : NetworkResult<T>()

    sealed class Error : NetworkResult<Nothing>() {
        data class Business(val code: Int, val message: String) : Error()
        data class Http(val code: Int, val message: String) : Error()
        data class Network(val throwable: Throwable) : Error()
    }
}
