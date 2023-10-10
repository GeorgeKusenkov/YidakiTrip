package com.example.yidakitrip.presentation.navigation.screen.lessonDetailed

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.yidakitrip.presentation.item.LessonImage
import com.example.yidakitrip.presentation.item.LessonElement
import com.example.yidakitrip.presentation.item.characters.CharacterLukaItem
import com.example.yidakitrip.presentation.item.characters.CharacterVaruItem
import com.example.yidakitrip.data.model.LessonContent
import com.example.yidakitrip.presentation.navigation.screen.MainViewModel
import com.example.yidakitrip.presentation.navigation.screen.RoomViewModel
import com.example.yidakitrip.presentation.navigation.screen.moduleItems.DataType

@Composable
fun LessonDetailedScreen(
    mainViewModel: MainViewModel,
    text: Int,
    moduleId: Int
) {
//    val actualLessonName = mainViewModel.actualContentName.value!!
//
//
//    Log.d("RATING", "--actualLessonName1: ${actualLessonName}")
//    Log.d("RATING", "--text: ${text}")
//    Log.d("RATING", "--moduleId: ${moduleId}")

    val roomViewModel: RoomViewModel = viewModel(factory = RoomViewModel.factory)

    LaunchedEffect(Unit) { mainViewModel.setTitle("Урок") }
    val lessonId = remember { mutableIntStateOf(text) }

    mainViewModel.getLessonContent(lessonId.intValue, DataType.LESSON, moduleId)
    mainViewModel.getFileNamesData(lessonId.intValue, DataType.LESSON)
    mainViewModel.setActualContentName(lessonId.intValue)


    val lessonElements by mainViewModel.lessonData.observeAsState(emptyList())
    val moduleItems by mainViewModel.moduleItems.observeAsState(emptyList())

    val size = moduleItems.size

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.weight(1f)) {
            content(lessonElements)
            item {
                Rating(
                    roomViewModel = roomViewModel,
                    mainViewModel = mainViewModel
                )
            }
            item {
                navigationButtons(
                    mainViewModel = mainViewModel,
//                    roomViewModel = roomViewModel,
                    lessonId = lessonId,
                    moduleId = moduleId,
                    moduleItemsSize = size
                )
            }
        }
    }
}

@Composable
fun Rating(
    roomViewModel: RoomViewModel,
    mainViewModel: MainViewModel,
    onRatingChanged: (Int) -> Unit = {}
) {

    val actualLessonName = mainViewModel.actualContentName.value
    if (actualLessonName != null) {
        roomViewModel.getActualRating(actualLessonName)
    }

    Log.d("RATING1", "--actualLessonName1: ${actualLessonName}")

    mainViewModel.actualContentName.value?.let { roomViewModel.getActualRating(it) }

//    roomViewModel.getActualRating(mainViewModel.actualContentName.value)

//    val curRating by remember {
//        mutableIntStateOf(0)
//    }
    val curRating by roomViewModel.currentRating.observeAsState(0)

    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (index in 1..5) {
            Icon(
                imageVector = if (index <= curRating) Icons.Filled.Star else Icons.Outlined.StarBorder,
                contentDescription = null,
                modifier = Modifier
                    .clickable {
                        roomViewModel.setActualRating(index)
                        onRatingChanged(index)
                        mainViewModel.actualContentName.value?.let {
                            roomViewModel.updateLesson(
                                it,
                                curRating
                            )
                        }
                    }
                    .size(40.dp)
            )
        }
    }
}

private fun LazyListScope.content(lessonContent: List<LessonContent>) {
    items(items = lessonContent) { element ->
        when (element.type) {
            LessonElement.TEXT -> Text(element.content)
            LessonElement.LUKA -> CharacterLukaItem(element.content)
            LessonElement.VARU -> CharacterVaruItem(element.content)
            LessonElement.IMAGE -> LessonImage(id = element.content.toInt())
            else -> Text(element.content)
        }
    }
}

@Composable
private fun navigationButtons(
    mainViewModel: MainViewModel,
    lessonId: MutableState<Int>,
    moduleId: Int,
    moduleItemsSize: Int,
//    roomViewModel: RoomViewModel
) {
//
//    item {
    Row {
        val isFirstLesson = lessonId.value == 0
        val isLastLesson = lessonId.value == moduleItemsSize
        val isMiddleLesson = lessonId.value in 1 until moduleItemsSize

        when (lessonId.value) {
            0 -> {
                NavigationButton("К модулю") {

                }
                NavigationButton("Вперёд") {
                    lessonId.value += 1
                    updateContent(mainViewModel, lessonId, moduleId)
                }
            }

            moduleItemsSize -> {
                NavigationButton("Назад") {
                    lessonId.value -= 1
                    updateContent(mainViewModel, lessonId, moduleId)
                }
                NavigationButton("Следующий модуль") {

                }
            }

            else -> {
                NavigationButton("Назад") {
                    lessonId.value -= 1
                    updateContent(mainViewModel, lessonId, moduleId)
                }
                NavigationButton("Вперёд") {
                    lessonId.value += 1
                    updateContent(mainViewModel, lessonId, moduleId)
                }
            }
//            }
//            if (isLastLesson || isMiddleLesson) {  // lessonId > 0 AND lessonId <= num1
//                BackButton {
//                    lessonId.value -= 1
//                    updateContent(mainViewModel, context, lessonId, moduleId)
//                }
//            }
//
//            if (isFirstLesson || isMiddleLesson) {  // lessonId >= 0 AND lessonId <= num1
//                NextButton() {
//                    lessonId.value += 1
//                    updateContent(mainViewModel, context, lessonId, moduleId)
//                }
//            }
        }
    }
}

@Composable
fun NavigationButton(text: String, onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text = text)
    }
}

private fun updateContent(
    mainViewModel: MainViewModel,
    lessonId: MutableState<Int>,
    moduleId: Int,
//    roomViewModel: RoomViewModel
) {
    mainViewModel.getLessonContent(lessonId.value, DataType.LESSON, moduleId)
    mainViewModel.setActualContentName(lessonId.value)
//    mainViewModel.actualContentName.value?.let { roomViewModel.insertLesson(it, true,3) }
}

