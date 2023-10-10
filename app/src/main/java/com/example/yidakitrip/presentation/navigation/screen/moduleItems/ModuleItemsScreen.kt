package com.example.yidakitrip.presentation.navigation.screen.moduleItems

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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.yidakitrip.presentation.item.ContentItemCard
import com.example.yidakitrip.presentation.navigation.DetailsScreen
import com.example.yidakitrip.presentation.navigation.screen.MainViewModel
import com.example.yidakitrip.presentation.navigation.screen.RoomViewModel

enum class DataType {
    COURSE,
    MODULE,
    LESSON,
    ALL
}

@Composable
fun ModuleItemsScreen(
    mainViewModel: MainViewModel,
    text: String,
    navController: NavController
) {
    val roomViewModel: RoomViewModel = viewModel(factory = RoomViewModel.factory)
//    var moduleItems by remember { mutableStateOf(emptyList<ItemContent>()) }

    LaunchedEffect(Unit) {
        mainViewModel.setTitle("Модули")

        //moduleItems.value - получаем список модулей
        mainViewModel.fetchContentData(id = text, dataType = DataType.COURSE)

        //lessonsNameList.value
//        mainViewModel.getLessonsNames(text.toInt(), dataType = DataType.MODULE)
    }

    val moduleItems by mainViewModel.moduleItems.observeAsState(emptyList())



    Log.d("12312312333", "moduleItems: ${moduleItems}")

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {
            itemsIndexed(items = moduleItems) { index: Int, module ->
//                mainViewModel.getLessonsNames(index, dataType = DataType.LESSON)
//                mainViewModel.moduleItems.value[0]
//                roomViewModel.getLessonId(lessonsNames[index])
//                roomViewModel.getAllLessonInfo(lessonsNames[index])

//                val lessonData = roomViewModel.actualLessonData.value
//                val passedProgress = moduleNames.size
//                val rating = lessonData?.rating ?: 0

                ContentItemCard(
                    contentItemList = module,
                    contentItemSize = 10,
                    passedProgress = 5,
                    rating = 2,
                    contentOnClick = {
                    navController.navigate(
                        route = DetailsScreen.Module.passId(
                            id = 1, name = index.toString()
                        )
                    )
//                    mainViewModel.setNameDataValue(moduleNames[index])
//                    Log.d("12312312333", "MODULE Items: ${mainViewModel.actualContentName.value}")
//                    mainViewModel.actualContentName.value?.let {
//                        roomViewModel.insertLesson(
//                            it,
//                            true,
//                            3)
//                    }
                    }
                )
            }
        }
    }
}