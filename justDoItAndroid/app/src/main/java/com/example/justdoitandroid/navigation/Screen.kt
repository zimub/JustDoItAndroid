package com.example.justdoitandroid.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    object Home : Screen("home", "首页", Icons.Default.Home)
    object Explore : Screen("explore", "探索", Icons.Default.Search)
    object Notification : Screen("notification", "通知", Icons.Default.Notifications)
    object Profile : Screen("profile", "我的", Icons.Default.Person)

    object TaskDetail : Screen("task_detail/{taskId}", "任务详情", Icons.Default.Home) {
        fun createRoute(taskId: Int) = "task_detail/$taskId"
    }

    companion object {
        val items = listOf(Home, Explore, Notification, Profile)
    }
}
