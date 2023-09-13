package com.example.yidakitrip.navigation

const val COURSE_ARGUMENT_KEY = "id"
const val COURSE_ARGUMENT_KEY2 = "name"
const val MODULE_ARGUMENT_KEY = "id"
const val MODULE_ARGUMENT_KEY2 = "name"
const val LESSON_ARGUMENT_KEY = "id"
const val LESSON_ARGUMENT_KEY2 = "name"
const val LESSON_DETAILED_ARGUMENT_KEY = "id"
const val LESSON_DETAILED_ARGUMENT_KEY2 = "name"

sealed class Screen(val route: String) {
    object Main: Screen(route = "main_screen")
    object Course: Screen(route = "course_screen/{$COURSE_ARGUMENT_KEY}/{$COURSE_ARGUMENT_KEY2}") {
//        fun passId(id: Int): String {
//            return this.route.replace(oldValue = "{$COURSE_ARGUMENT_KEY}", newValue = id.toString())
//        }
        fun passId(
            id: Int,
            name: String
        ): String {
            return "course_screen/$id/$name"
        }
    }

    object Module: Screen(route = "module_screen/{$MODULE_ARGUMENT_KEY}/{$MODULE_ARGUMENT_KEY2}") {
        fun passId(
            id: Int,
            name: String
        ): String {
            return "module_screen/$id/$name"
        }
    }

    object Lesson: Screen(route = "lesson_screen/{$LESSON_ARGUMENT_KEY}/{$LESSON_ARGUMENT_KEY2}") {
        fun passId(
            id: Int,
            name: String
        ): String {
            return "lesson_screen/$id/$name"
        }
    }

    object LessonDetailed: Screen(route = "lesson_detailed_screen/{$LESSON_DETAILED_ARGUMENT_KEY}/{$LESSON_DETAILED_ARGUMENT_KEY2}") {
        fun passId(
            id: Int,
            name: String
        ): String {
            return "lesson_detailed_screen/$id/$name"
        }
    }
}
