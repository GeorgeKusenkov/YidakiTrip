package com.example.yidakitrip.domain.repository

import com.example.yidakitrip.data.model.ItemContent
import com.example.yidakitrip.data.model.LessonContent
import com.example.yidakitrip.presentation.navigation.screen.moduleItems.DataType

interface Repository {
    fun getClassFiles(dataType: DataType, moduleId: Int): List<String>

    fun readJsonContentItemFile(filename: String): List<ItemContent>

    fun readJsonLessonContentFile(filename: String): List<LessonContent>
}