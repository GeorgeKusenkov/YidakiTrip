package com.example.yidakitrip.presentation.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.yidakitrip.presentation.navigation.DetailsScreen
import com.example.yidakitrip.presentation.navigation.screen.lessonDetailed.LessonDetailedScreen
import com.example.yidakitrip.presentation.navigation.screen.lessonItems.LessonItemsScreen
import com.example.yidakitrip.presentation.navigation.screen.moduleItems.ModuleItemsScreen
import com.example.yidakitrip.presentation.navigation.graph.Ars.COURSE_ARGUMENT_KEY
import com.example.yidakitrip.presentation.navigation.graph.Ars.COURSE_ARGUMENT_KEY2
import com.example.yidakitrip.presentation.navigation.graph.Ars.LESSON_ARGUMENT_KEY
import com.example.yidakitrip.presentation.navigation.graph.Ars.LESSON_ARGUMENT_KEY2
import com.example.yidakitrip.presentation.navigation.graph.Ars.LESSON_DETAILED_ARGUMENT_KEY
import com.example.yidakitrip.presentation.navigation.graph.Ars.LESSON_DETAILED_ARGUMENT_KEY2
import com.example.yidakitrip.presentation.navigation.graph.Ars.MODULE_ARGUMENT_KEY
import com.example.yidakitrip.presentation.navigation.graph.Ars.MODULE_ARGUMENT_KEY2
import com.example.yidakitrip.presentation.navigation.screen.MainViewModel

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController, mainViewModel: MainViewModel) {
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.Main.route
    ) {
        //Course Items
        composable(
            route = DetailsScreen.Course.route,
            arguments = listOf(
                navArgument(COURSE_ARGUMENT_KEY) { type = NavType.IntType },
                navArgument(COURSE_ARGUMENT_KEY2) { type = NavType.StringType }
            )
        ) {
            ModuleItemsScreen(
                mainViewModel = mainViewModel,
                text = it.arguments?.getString(COURSE_ARGUMENT_KEY2).toString(),
                navController = navController
            )
        }

        //Module Items
        composable(
            route = DetailsScreen.Module.route,
            arguments = listOf(
                navArgument(MODULE_ARGUMENT_KEY) { type = NavType.IntType },
                navArgument(MODULE_ARGUMENT_KEY2) { type = NavType.StringType }
            )
        ) {
            LessonItemsScreen(
                mainViewModel,
                text = it.arguments?.getString(MODULE_ARGUMENT_KEY2).toString(),
                navController = navController
            )
        }

        //Lesson Items
        composable(
            route = DetailsScreen.Lesson.route,
            arguments = listOf(
                navArgument(LESSON_ARGUMENT_KEY) { type = NavType.IntType },
                navArgument(LESSON_ARGUMENT_KEY2) { type = NavType.StringType }
            )
        ) {
            LessonItemsScreen(
                mainViewModel,
                text = it.arguments?.getString(LESSON_ARGUMENT_KEY2).toString(),
                navController = navController
            )
        }

        //Detailed Lesson
        composable(
            route = DetailsScreen.LessonDetailed.route,
            arguments = listOf(
                navArgument(LESSON_DETAILED_ARGUMENT_KEY) { type = NavType.IntType },
                navArgument(LESSON_DETAILED_ARGUMENT_KEY2) { type = NavType.IntType }
            )
        ) {
            LessonDetailedScreen(
                mainViewModel = mainViewModel,
                text = it.arguments?.getInt(LESSON_DETAILED_ARGUMENT_KEY2) ?: 0,
                moduleId = it.arguments?.getInt(LESSON_DETAILED_ARGUMENT_KEY) ?: 0
            )
        }
    }
}

object Ars {
    const val COURSE_ARGUMENT_KEY = "id"
    const val COURSE_ARGUMENT_KEY2 = "name"
    const val MODULE_ARGUMENT_KEY = "id"
    const val MODULE_ARGUMENT_KEY2 = "name"
    const val LESSON_ARGUMENT_KEY = "id"
    const val LESSON_ARGUMENT_KEY2 = "name"
    const val LESSON_DETAILED_ARGUMENT_KEY = "id"
    const val LESSON_DETAILED_ARGUMENT_KEY2 = "name"
}