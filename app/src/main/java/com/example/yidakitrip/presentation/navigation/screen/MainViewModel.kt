package com.example.yidakitrip.presentation.navigation.screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yidakitrip.data.model.ItemContent
import com.example.yidakitrip.data.model.LessonContent
import com.example.yidakitrip.domain.repository.JsonRepository
import com.example.yidakitrip.presentation.navigation.screen.moduleItems.DataType
import kotlinx.coroutines.launch

class MainViewModel(private val repository: JsonRepository): ViewModel() {



    private val _contentNameList = MutableLiveData<List<String>>()
    val contentNameList: LiveData<List<String>> get() = _contentNameList

    private val _lessonData = MutableLiveData<List<LessonContent>>()
    val lessonData: LiveData<List<LessonContent>> get() = _lessonData





    private val _actualContentName: MutableLiveData<String> = MutableLiveData("")
    val actualContentName: LiveData<String> get() = _actualContentName

    private val _allNameList = MutableLiveData<List<String>>()
    val allNameList: LiveData<List<String>> get() = _allNameList

    private val _moduleItems = MutableLiveData<List<ItemContent>>()
    val moduleItems: LiveData<List<ItemContent>> get() = _moduleItems

    private val _lessonsNameList = MutableLiveData<List<String>>()
    val lessonsNameList: LiveData<List<String>> get() = _lessonsNameList



//    fun setNameDataValue(value: String) {
//        _actualContentName.value = value
//    }

    fun fetchContentData(id: String, dataType: DataType) {
    viewModelScope.launch {
        val courseInfoFromRepo = repository.getModules(id, dataType)
        _moduleItems.value = courseInfoFromRepo
        Log.d("1231231233399", "fetchContentData: ${courseInfoFromRepo}")
        }
    }

    fun getLessonContent(lessonId: Int, dataType: DataType, moduleId: Int) {
        viewModelScope.launch {
            val lessonInfoFromRepo = repository.getLessonData(lessonId, dataType, moduleId)
            _lessonData.value = lessonInfoFromRepo
        }
    }

    fun getFileNamesData(id: Int, dataType: DataType){
        viewModelScope.launch {
            val listOfFileNames = repository.getFileNamesData(id = id, dataType = dataType)
            _contentNameList.value = listOfFileNames
        }
    }

    fun getAllFileNamesData(id: Int, dataType: DataType){
        viewModelScope.launch {
            val listOfFileNames = repository.getFileNamesData(id = id, dataType = dataType)
            _allNameList.value = listOfFileNames
        }
    }

    fun getLessonsNames(id: Int, dataType: DataType) {
        Log.d("1231231233399", "id: ${id}")
        Log.d("1231231233399", "dataType: ${dataType}")
        viewModelScope.launch {
            val listOfFileNames = repository.getFileNamesData(id = id, dataType = dataType)
            _lessonsNameList.value = listOfFileNames
            Log.d("1231231233399", "getLessonsNames: ${listOfFileNames}")
        }
    }

    fun setActualContentName(lessonId: Int) {
        _actualContentName.value = _contentNameList.value?.get(lessonId)
    }

    private var _screenTitle = MutableLiveData("")
    val screenTitle: LiveData<String>
        get() = _screenTitle

    fun setTitle(newTitle: String) {
        _screenTitle.value = newTitle
    }
}