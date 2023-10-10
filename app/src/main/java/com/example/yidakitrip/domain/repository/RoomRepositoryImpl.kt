package com.example.yidakitrip.domain.repository

import android.util.Log
import com.example.yidakitrip.data.room.AppDatabase
import com.example.yidakitrip.data.room.LessonProgress
import com.example.yidakitrip.data.room.LessonProgressDao

class RoomRepositoryImpl(db: AppDatabase) : RoomRepository {
    private val dao = db.lessonProgressDao()

    override suspend fun insert(progress: LessonProgress) {
        val exists = dao.exists(progress.lessonId)
        if(!exists) {
            dao.insert(progress)
            Log.d("Room", "Data ${progress.lessonId} ADDED")
        } else {
            Log.d("Room", "Data ${progress.lessonId} already exists")
        }
    }

    override suspend fun getById(id: String): LessonProgress {
        return dao.getById(id)
    }

    override suspend fun update(progress: LessonProgress) {
        dao.update(progress)
    }
}