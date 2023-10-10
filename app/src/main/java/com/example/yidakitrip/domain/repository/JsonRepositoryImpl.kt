package com.example.yidakitrip.domain.repository

import android.util.Log
import com.example.yidakitrip.data.model.ItemContent
import com.example.yidakitrip.data.model.LessonContent
import com.example.yidakitrip.presentation.navigation.screen.moduleItems.DataType

class JsonRepositoryImpl(
    private val repository: Repository,
): JsonRepository {

    override suspend fun getModules(id: String, dataType: DataType): List<ItemContent> {
        val files = repository.getClassFiles(dataType, 1000)
        val info = repository.readJsonContentItemFile(files[id.toInt()])
        return info
    }

    override suspend fun getLessonData(id: Int, dataType: DataType, moduleId: Int): List<LessonContent> {
        val files = repository.getClassFiles(dataType, moduleId)
        val info = repository.readJsonLessonContentFile(files[id])
        return info
    }

    override suspend fun getFileNamesData(id: Int, dataType: DataType): List<String>
    {
        val files = repository.getClassFiles(dataType, id)

        Log.d("123123123","!FILES LESSON: $files")
        Log.d("123123123","!id: $id")
        Log.d("123123123","!dataType: $dataType")

        return repository.getClassFiles(dataType, id)
    }

//    override suspend fun insertLessonProgress(lessonId: String, isComplete: Boolean, rating: Int) {
////        lessonProgressRepository.insert(LessonProgress(lessonId, isComplete, rating))
//    }
//
//    override suspend fun getLessonProgress(
//        lessonId: String,
//        isComplete: Boolean,
//        rating: Int
//    ): LessonProgress {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun updateLessonProgress(lessonId: String, isComplete: Boolean, rating: Int) {
//        TODO("Not yet implemented")
//    }
}