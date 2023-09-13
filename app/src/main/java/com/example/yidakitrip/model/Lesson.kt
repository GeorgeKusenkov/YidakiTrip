package com.example.yidakitrip.model

import com.example.yidakitrip.items.LessonElement

data class Lesson(
    val isFirstLesson: Boolean = false,
    val isLastLesson: Boolean = false,
    val lessonContent: List<LessonContent>
)
