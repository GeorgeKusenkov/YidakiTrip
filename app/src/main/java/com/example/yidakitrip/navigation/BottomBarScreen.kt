package com.example.yidakitrip.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Study: BottomBarScreen(
        route = "study_screen",
        title = "Обучение",
        icon = Icons.Default.Home
    )

    object Profile: BottomBarScreen(
        route = "profile",
        title = "Профиль",
        icon = Icons.Default.Person
    )

    object Practice: BottomBarScreen(
        route = "practice",
        title = "Практика",
        icon = Icons.Default.PlayArrow
    )

    object About: BottomBarScreen(
        route = "about",
        title = "О нас",
        icon = Icons.Default.Face
    )
}