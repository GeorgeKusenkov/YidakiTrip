package com.example.yidakitrip.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface LessonProgressDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(progress: LessonProgress)

    @Query("SELECT * FROM progress LessonProgress WHERE lessonId = :id")
    suspend fun getById(id: String): LessonProgress

    @Update
    suspend fun update(progress: LessonProgress)

    @Query("SELECT EXISTS(SELECT 1 FROM progress WHERE lessonId = :id)")
    suspend fun exists(id: String): Boolean
}