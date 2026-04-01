package com.example.justdoitandroid.ui.screens.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.justdoitandroid.base.BaseViewModel
import com.example.justdoitandroid.data.model.Task
import com.example.justdoitandroid.data.repository.TaskRepository
import com.example.justdoitandroid.network.NetworkResult
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class HomeUiState {
    object Loading : HomeUiState()
    data class Success(val tasks: List<Task>) : HomeUiState()
    data class Error(val message: String) : HomeUiState()
}

class HomeViewModel : BaseViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    override fun onPageEnter() {
        super.onPageEnter()
        Log.d("HomeViewModel", "========== 进入首页 ==========")
        loadTasks()
    }

    override fun onPageLeave() {
        super.onPageLeave()
        Log.d("HomeViewModel", "========== 离开首页 ==========")
    }

    private fun loadTasks() {
        // 已有数据时不重复请求（ViewModel 跨 Tab 存活，数据无需重新加载）
        if (_uiState.value is HomeUiState.Success) return

        viewModelScope.launch {
            _uiState.value = HomeUiState.Loading
            when (val result = TaskRepository.getTasks()) {
                is NetworkResult.Success ->
                    _uiState.value = HomeUiState.Success(result.data)
                is NetworkResult.Error.Business ->
                    _uiState.value = HomeUiState.Error("业务错误 [${result.code}]：${result.message}")
                is NetworkResult.Error.Http ->
                    _uiState.value = HomeUiState.Error("HTTP 错误 [${result.code}]：${result.message}")
                is NetworkResult.Error.Network ->
                    _uiState.value = HomeUiState.Error("网络异常：${result.throwable.message}")
            }
        }
    }
}
