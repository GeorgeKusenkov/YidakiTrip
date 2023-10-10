package com.example.yidakitrip.domain.repository

import com.example.yidakitrip.data.model.ItemContent
import com.example.yidakitrip.data.model.LessonContent
import com.example.yidakitrip.presentation.navigation.screen.moduleItems.DataType

interface JsonRepository {
    suspend fun getModules(id: String, dataType: DataType): List<ItemContent>
    suspend fun getFileNamesData(id: Int, dataType: DataType): List<String>
    suspend fun getLessonData(
        id: Int,
        dataType: DataType,
        moduleId: Int
    ): List<LessonContent>

//    suspend fun insertLessonProgress(lessonId: String, isComplete: Boolean, rating: Int)
//    suspend fun getLessonProgress(lessonId: String, isComplete: Boolean, rating: Int): LessonProgress
//    suspend fun updateLessonProgress(lessonId: String, isComplete: Boolean, rating: Int)
}