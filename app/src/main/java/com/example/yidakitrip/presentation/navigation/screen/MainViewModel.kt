package com.example.yidakitrip.presentation.navigation.screen

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yidakitrip.data.model.ItemContent
import com.example.yidakitrip.data.model.LessonContent
import com.example.yidakitrip.domain.repository.ContentRepository
import com.example.yidakitrip.domain.repository.ContentRepositoryImpl
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ContentRepository): ViewModel() {
    constructor() : this(ContentRepositoryImpl())

    private val _moduleItems = MutableLiveData<List<ItemContent>>()
    val moduleItems: LiveData<List<ItemContent>> get() = _moduleItems

    private val _lessonData = MutableLiveData<List<LessonContent>>()
    val lessonData: LiveData<List<LessonContent>> get() = _lessonData

    fun fetchContentData(context: Context, id: String, dataType: DataType) {
    viewModelScope.launch {
        val courseInfo = repository.getModules(context, id, dataType)
        _moduleItems.value = courseInfo
        }
    }
    fun fetchLessonData(
        context: Context,
        id: Int,
        dataType: DataType,
        moduleId: Int
    ) {
        viewModelScope.launch {
            val courseInfo = repository.getLessonData(context, id, dataType, moduleId)
            _lessonData.value = courseInfo
        }
    }

    private var _screenTitle = MutableLiveData("")
    val screenTitle: LiveData<String>
        get() = _screenTitle

    fun setTitle(newTitle: String) {
        _screenTitle.value = newTitle
    }
}