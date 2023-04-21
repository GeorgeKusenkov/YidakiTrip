package com.example.yidakitrip

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Main.route
    ) {
        composable(
            route = Screen.Main.route
        ) {
            HomeScreen(navController = navController)
        }

        composable(
            route = Screen.Course.route,
            arguments = listOf(
                navArgument(COURSE_ARGUMENT_KEY) {
                    type = NavType.IntType
                },
                navArgument(COURSE_ARGUMENT_KEY2) {
                    type = NavType.StringType
                })
        ) {
//            Log.d("Args", it.arguments?.getInt(COURSE_ARGUMENT_KEY).toString())
//            Log.d("Args", it.arguments?.getString(COURSE_ARGUMENT_KEY2).toString())
            CourseScreen(it.arguments?.getString(COURSE_ARGUMENT_KEY2).toString())
        }
    }
}