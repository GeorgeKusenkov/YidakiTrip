package com.example.yidakitrip.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.yidakitrip.navigation.screen.AboutScreen
import com.example.yidakitrip.navigation.BottomBarScreen
import com.example.yidakitrip.navigation.screen.CourseScreen
import com.example.yidakitrip.navigation.screen.PracticeScreen
import com.example.yidakitrip.navigation.screen.ProfileScreen

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Study.route    //!!!!!!!!!!!!!!!!!!!!!!!!!!!
    ) {
        composable(route = BottomBarScreen.Study.route) {
            CourseScreen(navController = navController)
        }

        composable(route = BottomBarScreen.Practice.route) {
            PracticeScreen()
        }

        composable(route = BottomBarScreen.Profile.route) {
            ProfileScreen()
        }

        composable(route = BottomBarScreen.About.route) {
            AboutScreen()
        }
        detailsNavGraph(navController = navController)
    }
}