package com.example.justdoitandroid.ui.screens.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.justdoitandroid.base.BaseViewModel
import com.example.justdoitandroid.data.model.Task
import com.example.justdoitandroid.data.repository.TaskRepository
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
    // 私有的可写流
    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    // 对外暴露的只读流
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
        viewModelScope.launch {
            _uiState.value = HomeUiState.Loading
            try {
                val tasks = TaskRepository.getTasks()
                _uiState.value = HomeUiState.Success(tasks)
            } catch (e: Exception) {
                _uiState.value = HomeUiState.Error(e.message ?: "未知错误")
            }
        }
    }
}
