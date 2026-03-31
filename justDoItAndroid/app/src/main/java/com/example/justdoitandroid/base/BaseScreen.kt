package com.example.justdoitandroid.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect

/**
 * 所有页面的基础容器，统一管理进页/离页生命周期。
 *
 * 用法：
 * ```
 * @Composable
 * fun HomeScreen(viewModel: HomeViewModel = viewModel()) {
 *     BaseScreen(viewModel) {
 *         // 页面内容
 *     }
 * }
 * ```
 */
@Composable
fun BaseScreen(
    viewModel: BaseViewModel,
    content: @Composable () -> Unit
) {
    DisposableEffect(viewModel) {
        viewModel.onPageEnter()
        onDispose {
            viewModel.onPageLeave()
        }
    }
    content()
}
