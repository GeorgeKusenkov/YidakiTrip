package com.example.yidakitrip.navigation.bottomNavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.yidakitrip.navigation.HomeScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination =  BottomBarScreen.Study.route
    ) {
        composable(route = BottomBarScreen.Study.route) {
            HomeScreen(navController = navController)
        }

        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen()
        }

        composable(route = BottomBarScreen.Practice.route) {
            PracticeScreen()
        }

        composable(route = BottomBarScreen.About.route) {
            AboutScreen()
        }
    }
}