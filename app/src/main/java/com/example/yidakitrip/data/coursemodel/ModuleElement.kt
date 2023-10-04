package com.example.yidakitrip.data.coursemodel

data class ModuleElement(
    val id: String,
    val title: String,
    val description: String,
    val image: String,
    val lessonElements: List<LessonElement>
)