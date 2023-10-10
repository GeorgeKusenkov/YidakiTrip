package com.example.yidakitrip.data.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "progress")
data class LessonProgress(
    @PrimaryKey
    val lessonId: String,
    var isComplete: Boolean = false,
    var rating: Int = 0
)