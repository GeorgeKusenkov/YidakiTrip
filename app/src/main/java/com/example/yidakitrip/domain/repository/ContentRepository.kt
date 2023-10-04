package com.example.yidakitrip.domain.repository

import android.content.Context
import com.example.yidakitrip.data.model.ItemContent
import com.example.yidakitrip.data.model.LessonContent
import com.example.yidakitrip.presentation.navigation.screen.DataType

interface ContentRepository {
    suspend fun getModules(context: Context, id: String, dataType: DataType): List<ItemContent>
    suspend fun getLessonData(
        context: Context,
        id: Int,
        dataType: DataType,
        moduleId: Int
    ): List<LessonContent>
}