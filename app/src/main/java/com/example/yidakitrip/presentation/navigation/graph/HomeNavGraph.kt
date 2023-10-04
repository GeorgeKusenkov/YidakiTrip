package com.example.yidakitrip.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.yidakitrip.presentation.navigation.screen.bottommenu.AboutScreen
import com.example.yidakitrip.presentation.navigation.BottomBarScreen
import com.example.yidakitrip.presentation.navigation.screen.bottommenu.CourseScreen
import com.example.yidakitrip.presentation.navigation.screen.MainViewModel
import com.example.yidakitrip.presentation.navigation.screen.bottommenu.PracticeScreen
import com.example.yidakitrip.presentation.navigation.screen.bottommenu.ProfileScreen

@Composable
fun HomeNavGraph(navController: NavHostController, mainViewModel: MainViewModel) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Study.route
    ) {
        composable(route = BottomBarScreen.Study.route) {
            CourseScreen(navController = navController, mainViewModel = mainViewModel)
        }

        composable(route = BottomBarScreen.Practice.route) {
            PracticeScreen(mainViewModel = mainViewModel)
        }

        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen(mainViewModel = mainViewModel)
        }

        composable(route = BottomBarScreen.About.route) {
            AboutScreen(mainViewModel = mainViewModel)
        }
        detailsNavGraph(navController = navController, mainViewModel)
    }
}