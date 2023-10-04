package com.example.yidakitrip.presentation.navigation.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.yidakitrip.presentation.navigation.DetailsScreen
import com.example.yidakitrip.presentation.item.ModuleItem

@Composable
fun LessonItemsScreen(
    mainViewModel: MainViewModel,
    text: String,
    navController: NavController
) {
    Log.d("awfwafwaf", "LessonItemsScreen in text: $text")

    val context = LocalContext.current
    LaunchedEffect(Unit) {
        mainViewModel.setTitle("Уроки")
        mainViewModel.fetchContentData(context = context, id = text, dataType = DataType.MODULE)
    }

    val moduleItems by mainViewModel.moduleItems.observeAsState(emptyList())

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {
            itemsIndexed(items = moduleItems) { index: Int, lesson ->
                    ModuleItem(lesson, contentOnClick = {
                        navController.navigate(
                            route = DetailsScreen.LessonDetailed.passId(
                                id = text.toInt(),
                                name = "$index"
                            )
                        )
                    }
                )
            }
        }
    }
}