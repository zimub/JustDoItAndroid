package com.example.justdoitandroid.network

import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

/**
 * 统一网络请求管理类，集中处理所有错误场景：
 *
 * 使用示例：
 * ```kotlin
 * val result = NetworkManager.request { RetrofitClient.apiService.getTasks() }
 * when (result) {
 *     is NetworkResult.Success       -> { /* 使用 result.data */ }
 *     is NetworkResult.BusinessError -> { /* 业务码：result.code, result.message */ }
 *     is NetworkResult.HttpError     -> { /* HTTP码：result.code, result.message */ }
 *     is NetworkResult.Exception     -> { /* 异常：result.throwable */ }
 * }
 * ```
 */
object NetworkManager {

    /** 业务层成功码，根据后端约定修改 */
    private const val BUSINESS_SUCCESS_CODE = 200

    suspend fun <T> request(
        call: suspend () -> Response<ApiResponse<T>>
    ): NetworkResult<T> {
        return try {
            handleResponse(call())
        } catch (e: HttpException) {
            // Retrofit 抛出的 HTTP 错误
            NetworkResult.HttpError(e.code(), e.message())
        } catch (e: IOException) {
            // 无网络、连接超时等 IO 异常
            NetworkResult.Exception(e)
        } catch (e: Throwable) {
            // JSON 解析失败等其他异常
            NetworkResult.Exception(e)
        }
    }

    private fun <T> handleResponse(response: Response<ApiResponse<T>>): NetworkResult<T> {
        // 第一层：HTTP 错误码检查（4xx / 5xx）
        if (!response.isSuccessful) {
            return NetworkResult.HttpError(response.code(), response.message())
        }

        val body = response.body()
            ?: return NetworkResult.HttpError(response.code(), "响应体为空")

        // 第二层：业务错误码检查
        return if (body.code == BUSINESS_SUCCESS_CODE) {
            body.data?.let { NetworkResult.Success(it) }
                ?: NetworkResult.BusinessError(body.code, "data 字段为空")
        } else {
            NetworkResult.BusinessError(body.code, body.message)
        }
    }
}
