package com.example.yidakitrip.presentation.navigation.screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.yidakitrip.data.room.App
import com.example.yidakitrip.data.room.LessonProgress
import com.example.yidakitrip.domain.repository.RoomRepository
import com.example.yidakitrip.domain.repository.RoomRepositoryImpl
import kotlinx.coroutines.launch

class RoomViewModel(private val repository: RoomRepository) : ViewModel() {

    private val _actualContentName: MutableLiveData<String> = MutableLiveData("")
    val actualContentName: LiveData<String> get() = _actualContentName

    private val _currentRating: MutableLiveData<Int> = MutableLiveData(0)
    val currentRating: LiveData<Int> get() = _currentRating

    private val _actualLessonData: MutableLiveData<LessonProgress> = MutableLiveData()
    val actualLessonData: LiveData<LessonProgress> get() = _actualLessonData

    init {
        insertLesson("data_1_1.json",false, 0)
        insertLesson("data_1_1_1.json", false,0)
    }

    //СДЕЛАТЬ ЭТО НА УРОВНЕ РЕПОЗИТОРИЯ!
    fun loadAllDataToRoom(allData: List<String>) {
        viewModelScope.launch {
            for (i in allData) {
                repository.insert(LessonProgress(i,false,0))
            }
        }
    }

    fun insertLesson(lessonId: String, isComplete: Boolean, rating: Int) {
        viewModelScope.launch {
            repository.insert(LessonProgress(lessonId,isComplete,rating))
        }
    }

    fun getLessonId(lessonId: String) {
        viewModelScope.launch {
             _actualContentName.value = repository.getById(lessonId)?.lessonId
        }
    }

    fun getAllLessonInfo(lessonId: String) {
        viewModelScope.launch {
            _actualLessonData.value = repository.getById(lessonId)
        }
    }

    fun getActualRating(lessonId: String) {
        viewModelScope.launch {
            Log.d("RATING", "getActualRating: ${_currentRating.value}")
            Log.d("RATING", "lessonId: $lessonId")
            _currentRating.value = repository.getById(lessonId)?.rating
        }
    }

    fun setActualRating(rating: Int) {
        viewModelScope.launch {
            Log.d("RATING", "setActualRating: ${_currentRating.value}")
            Log.d("RATING", "rating fromBD: $rating")
            _currentRating.value = rating
        }
    }


    fun updateLesson(lessonId: String, rating: Int) {
        viewModelScope.launch {
            repository.update(LessonProgress(lessonId, true, rating))
        }
    }

    companion object{
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                    val database = (checkNotNull(extras[APPLICATION_KEY]) as App).dataBase
                    val repository = RoomRepositoryImpl(database)
                return RoomViewModel(repository) as T
            }
        }
    }
}