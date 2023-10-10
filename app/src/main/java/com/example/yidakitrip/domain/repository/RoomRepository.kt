package com.example.yidakitrip.domain.repository

import com.example.yidakitrip.data.room.LessonProgress

interface RoomRepository {
    suspend fun insert(progress: LessonProgress)
    suspend fun getById(id: String): LessonProgress?
    suspend fun update(progress: LessonProgress)
}