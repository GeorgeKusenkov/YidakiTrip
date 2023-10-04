package com.example.yidakitrip.data.model

data class Lesson(
    val isFirstLesson: Boolean = false,
    val isLastLesson: Boolean = false,
    val lessonContent: List<LessonContent>
)
