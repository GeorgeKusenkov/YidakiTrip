package com.example.yidakitrip.data.coursemodel

data class CourseElement(
    val id: Int,
    val title: String,
    val description: String,
    val image: String,
    val moduleElements: List<ModuleElement>
)