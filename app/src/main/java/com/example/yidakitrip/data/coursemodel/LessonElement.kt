package com.example.yidakitrip.data.coursemodel

data class LessonElement(
    val id: String,
    val title: String,
    val description: String,
    val image: String,
    val resources: List<Resource>,
)