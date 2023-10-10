package com.example.yidakitrip.domain.repository

import android.content.Context
import com.example.yidakitrip.data.model.ItemContent
import com.example.yidakitrip.data.model.LessonContent
import com.example.yidakitrip.presentation.navigation.screen.moduleItems.DataType
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class RepositoryImpl(private val context: Context) : Repository {

    override fun getClassFiles(dataType: DataType, moduleId: Int): List<String> {
        val listData = getAssetFileNames(context, "courseinfo")
        val regex = Regex("data_")
        val course = mutableListOf<String>()
        val module = mutableListOf<String>()
        val lesson = mutableListOf<String>()
        val allData = mutableListOf<String>()
        listData.forEach { filename ->
            val fields = filename.replace(regex, "").split("_")
            allData.add(filename)
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

        sortListByLastElement(list = course)
        sortListByLastElement(list = module)
        sortListByLastElement(list = lesson)

//        Log.d("qwe123", "course: $course")
//        Log.d("qwe123", "module: $module")
//        Log.d("qwe123", "lesson: $lesson")
//        Log.d("qwe123", "allData: $allData")

        return when(dataType) {
            DataType.COURSE -> course
            DataType.MODULE -> module
            DataType.LESSON -> lesson
            DataType.ALL -> allData
        }
    }

    override fun readJsonContentItemFile(filename: String): List<ItemContent> {
        val json = context.assets.open("courseinfo/$filename").bufferedReader().use { it.readText() }
        val itemType = object : TypeToken<List<ItemContent>>() {}.type
        return Gson().fromJson(json, itemType)
    }

    override fun readJsonLessonContentFile(filename: String): List<LessonContent> {
        val json = context.assets.open("courseinfo/$filename").bufferedReader().use { it.readText() }
        val itemType = object : TypeToken<List<LessonContent>>() {}.type
        return Gson().fromJson(json, itemType)
    }
}

//Get list of file names from assets folder
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
