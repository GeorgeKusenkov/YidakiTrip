package com.example.yidakitrip.domain.repository

import android.content.Context
import com.example.yidakitrip.data.model.ItemContent
import com.example.yidakitrip.data.model.LessonContent
import com.example.yidakitrip.presentation.navigation.screen.DataType
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class ContentRepositoryImpl: ContentRepository {
    override suspend fun getModules(context: Context, id: String, dataType: DataType): List<ItemContent> {
        val elementInfo = getClassFiles(context, dataType, moduleId = 1000)
        return readJsonContentItemFile(context, elementInfo[id.toInt()])
    }

    override suspend fun getLessonData(
        context: Context,
        id: Int,
        dataType: DataType,
        moduleId: Int
    ): List<LessonContent> {
        val lessonInfo = getClassFiles(context, dataType, moduleId)
        return readJsonLessonContentFile(context, lessonInfo[id])
    }
}

fun getIndexedElement(index: Int, listData: List<String>): String {
    return listData[index]
}
fun getClassFiles(context: Context, dataType: DataType, moduleId: Int): List<String> {
    val listData = getAssetFileNames(context, "courseinfo")
    val regex = Regex("data_")

    val course = mutableListOf<String>()
    val module = mutableListOf<String>()
    val lesson = mutableListOf<String>()

    listData.forEach { filename ->
        val fields = filename.replace(regex, "").split("_")
        when(fields.size) {
            1 -> course.add(filename)
            2 -> module.add(filename)
            3 -> {
                if (moduleId!=1000) {
                    if (filterListById(moduleId, filename)) {
                        lesson.add(filename)
                    }
                }
            }
        }
    }

    sortListByLastElement(course)
    sortListByLastElement(module)
    sortListByLastElement(lesson)

    return when(dataType) {
        DataType.COURSE -> course
        DataType.MODULE -> module
        DataType.LESSON -> lesson
    }
}

fun getAssetFileNames(context: Context, folderName: String): List<String> {
    val assetManager = context.assets
    val fileNames = mutableListOf<String>()
    try {
        val files = assetManager.list(folderName)
        if (files != null) {
            for (fileName in files) {
                fileNames.add(fileName)
            }
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }

    return fileNames
}

fun readJsonContentItemFile(context: Context, filename: String): List<ItemContent> {
    val json = context.assets.open("courseinfo/$filename").bufferedReader().use { it.readText() }
    val itemType = object : TypeToken<List<ItemContent>>() {}.type
    return Gson().fromJson(json, itemType)
}

fun readJsonLessonContentFile(context: Context, filename: String): List<LessonContent> {
    val json = context.assets.open("courseinfo/$filename").bufferedReader().use { it.readText() }
    val itemType = object : TypeToken<List<LessonContent>>() {}.type
    return Gson().fromJson(json, itemType)
}

fun filterListById(id: Int, filename: String): Boolean {
    val parts = filename.removeSuffix(".json").split("_")
    return parts[2].toInt() == id+1
}

fun sortListByLastElement(list: MutableList<String>) {
    list.sortBy { fileName ->
        val lastElement = fileName.substringAfterLast("_").removeSuffix(".json")
        lastElement.toInt()
    }
}