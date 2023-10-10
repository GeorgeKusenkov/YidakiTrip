package com.example.yidakitrip.presentation.navigation.graph

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.yidakitrip.domain.repository.JsonRepositoryImpl
import com.example.yidakitrip.domain.repository.RepositoryImpl
import com.example.yidakitrip.presentation.navigation.screen.HomeScreen
import com.example.yidakitrip.presentation.navigation.screen.MainViewModel

@Composable
fun RootNavGraph(navController: NavHostController) {
        NavHost(
            navController = navController,
            route = Graph.ROOT,
            startDestination = Graph.HOME
        ) {
            composable(route = Graph.HOME) {
                HomeScreen()
            }
        }
}




//class MainViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
////        val database = (checkNotNull(extras[APPLICATION_KEY]) as App).dataBase
//        val repository = ContentRepositoryImpl(RepositoryImpl(context))
//        return MainViewModel(repository)as T
//    }
//}

object Graph {
    const val ROOT = "root_graph"
    const val HOME = "home_graph"
    const val DETAILS = "details_graph"
}