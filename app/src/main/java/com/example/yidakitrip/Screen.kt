package com.example.yidakitrip

const val COURSE_ARGUMENT_KEY = "id"
const val COURSE_ARGUMENT_KEY2 = "name"

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
}
