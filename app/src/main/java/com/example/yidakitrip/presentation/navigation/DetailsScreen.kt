package com.example.yidakitrip.presentation.navigation

import com.example.yidakitrip.presentation.navigation.graph.Ars


sealed class DetailsScreen(val route: String) {
    object Main: DetailsScreen(route = "main_screen")
    object Course: DetailsScreen(route = "course_screen/{${Ars.COURSE_ARGUMENT_KEY}}/{${Ars.COURSE_ARGUMENT_KEY2}}") {
        fun passId(
            id: Int,
            name: String
        ): String {
            return "course_screen/$id/$name"
        }
    }

    object Module: DetailsScreen(route = "module_screen/{${Ars.MODULE_ARGUMENT_KEY}}/{${Ars.MODULE_ARGUMENT_KEY2}}") {
        fun passId(
            id: Int,
            name: String,
        ): String {
            return "module_screen/$id/$name"
        }
    }
    object Lesson: DetailsScreen(route = "lesson_screen/{${Ars.LESSON_ARGUMENT_KEY}}/{${Ars.LESSON_ARGUMENT_KEY2}}")

    object LessonDetailed: DetailsScreen(
        route = "lesson_detailed_screen/{${Ars.LESSON_DETAILED_ARGUMENT_KEY}}/{${Ars.LESSON_DETAILED_ARGUMENT_KEY2}}") {
        fun passId(
            id: Int,
            name: String
        ): String {
            return "lesson_detailed_screen/$id/$name"
        }
    }
}
