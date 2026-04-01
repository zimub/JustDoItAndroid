package com.example.justdoitandroid.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * 以 375dp 为基准宽度，按当前屏幕宽度等比缩放。
 *
 * 用法：
 * ```kotlin
 * Modifier.size(50.scale)
 * Modifier.width(200.scale)
 * ```
 */
private const val DESIGN_WIDTH = 375f

/** Int 缩放为 Dp，例：50.scale */
val Int.scale: Dp
    @Composable get() = (this * LocalConfiguration.current.screenWidthDp / DESIGN_WIDTH).dp

/** Float 缩放为 Dp，例：12.5f.scale */
val Float.scale: Dp
    @Composable get() = (this * LocalConfiguration.current.screenWidthDp / DESIGN_WIDTH).dp

/** Double 缩放为 Dp，例：12.5.scale */
val Double.scale: Dp
    @Composable get() = (this.toFloat() * LocalConfiguration.current.screenWidthDp / DESIGN_WIDTH).dp
