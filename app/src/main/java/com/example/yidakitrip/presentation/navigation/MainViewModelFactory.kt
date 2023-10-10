package com.example.yidakitrip.presentation.navigation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.yidakitrip.domain.repository.JsonRepositoryImpl
import com.example.yidakitrip.domain.repository.RepositoryImpl
import com.example.yidakitrip.presentation.navigation.screen.MainViewModel

class MainViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val repository = JsonRepositoryImpl(RepositoryImpl(context))
        return MainViewModel(repository) as T
    }
}