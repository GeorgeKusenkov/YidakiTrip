package com.example.yidakitrip.presentation.navigation.screen.lessonItems

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
import androidx.navigation.NavController
import com.example.yidakitrip.presentation.navigation.DetailsScreen
import com.example.yidakitrip.presentation.item.ContentItemCard
import com.example.yidakitrip.presentation.navigation.screen.MainViewModel
import com.example.yidakitrip.presentation.navigation.screen.moduleItems.DataType

@Composable
fun LessonItemsScreen(
    mainViewModel: MainViewModel,
    text: String,
    navController: NavController
) {
    LaunchedEffect(Unit) {
        mainViewModel.setTitle("Уроки")
        mainViewModel.fetchContentData(id = text, dataType = DataType.MODULE)
//        mainViewModel.getFileNamesData(text.toInt(), dataType = DataType.LESSON)
    }

//    val roomViewModel: RoomViewModel = viewModel(factory = RoomViewModel.factory)
    val moduleItems by mainViewModel.moduleItems.observeAsState(emptyList())
    val moduleNames by mainViewModel.contentNameList.observeAsState(emptyList())

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {
            itemsIndexed(items = moduleItems) { index: Int, lesson ->

//                roomViewModel.getLessonId(moduleNames[index])
//                val lessonData = roomViewModel.actualLessonData.value
//                val isComplete = lessonData?.isComplete ?: false
//                val passedProgress = if (isComplete) 1 else 0
//                val rating = lessonData?.rating ?: 0

                    ContentItemCard(
                        contentItemList = lesson,
                        contentItemSize = 10,
                        passedProgress = 7,
                        rating = 3,
                        contentOnClick = {
                        navController.navigate(
                            route = DetailsScreen.LessonDetailed.passId(
                                id = text.toInt(),
                                name = "$index"
                            )
                        )
//                        mainViewModel.setNameDataValue(moduleNames[index])
//                        mainViewModel.actualContentName.value?.let {
//                            roomViewModel.insertLesson(
//                                lessonId = it,
//                                isComplete = true,
//                                rating = 3
//                            )
//                        }
                    }
                )
            }
        }
    }
}