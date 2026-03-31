package com.example.justdoitandroid.main

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.justdoitandroid.base.BaseScreen

@Composable
fun MainScreen(viewModel: MainViewModel = viewModel()) {
    BaseScreen(viewModel) {
        Text(text = "Hello Android!")
    }
}

