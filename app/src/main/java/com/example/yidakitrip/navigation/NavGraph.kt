package com.example.yidakitrip.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.yidakitrip.navigation.bottomNavigation.AboutScreen
import com.example.yidakitrip.navigation.bottomNavigation.BottomBarScreen
import com.example.yidakitrip.navigation.bottomNavigation.PracticeScreen
import com.example.yidakitrip.navigation.bottomNavigation.ProfileScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Main.route
    ) {
        composable(route = Screen.Main.route) {
            HomeScreen(navController = navController)
        }

        //Course Items
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
            ModuleItemsScreen(
                text = it.arguments?.getString(COURSE_ARGUMENT_KEY2).toString(),
                navController = navController
            )
        }

        //Module Items
        composable(
            route = Screen.Module.route,
            arguments = listOf(
                navArgument(MODULE_ARGUMENT_KEY) {
                    type = NavType.IntType
                },
                navArgument(MODULE_ARGUMENT_KEY2) {
                    type = NavType.StringType
                })
        ) {
            LessonItemsScreen(
                text = it.arguments?.getString(MODULE_ARGUMENT_KEY2).toString(),
                navController = navController
            )
        }

        //Lesson Items
        composable(
            route = Screen.Lesson.route,
            arguments = listOf(
                navArgument(LESSON_ARGUMENT_KEY) {
                    type = NavType.IntType
                },
                navArgument(LESSON_ARGUMENT_KEY2) {
                    type = NavType.StringType
                })
        ) {
            LessonItemsScreen(
                text = it.arguments?.getString(LESSON_ARGUMENT_KEY2).toString(),
                navController = navController
            )
        }

        //Detailed Lesson
        composable(
            route = Screen.LessonDetailed.route,
            arguments = listOf(
                navArgument(LESSON_DETAILED_ARGUMENT_KEY) {
                    type = NavType.IntType
                },
                navArgument(LESSON_DETAILED_ARGUMENT_KEY2) {
                    type = NavType.StringType
                })
        ) {
            LessonDetailedScreen(
                text = it.arguments?.getString(LESSON_DETAILED_ARGUMENT_KEY2).toString(),
//                navController = navController
            )
        }

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