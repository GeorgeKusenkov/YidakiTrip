package com.example.yidakitrip.presentation.navigation.screen

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.yidakitrip.presentation.item.LessonImage
import com.example.yidakitrip.presentation.item.LessonElement
import com.example.yidakitrip.presentation.item.characters.CharacterLukaItem
import com.example.yidakitrip.presentation.item.characters.CharacterVaruItem
import com.example.yidakitrip.data.model.LessonContent

@Composable
fun LessonDetailedScreen(
    mainViewModel: MainViewModel,
    text: Int,
    moduleId: Int
) {
    val context = LocalContext.current
    mainViewModel.fetchLessonData(
        context = context,
        id = text,
        dataType = DataType.LESSON,
        moduleId = moduleId
    )
    LaunchedEffect(Unit){ mainViewModel.setTitle("Урок") }

    val lessonId = remember { mutableIntStateOf(text) }
    val lessonItems by mainViewModel.lessonData.observeAsState(emptyList())
    val moduleItems by mainViewModel.moduleItems.observeAsState(emptyList())
    val size = moduleItems.size

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            content(lessonItems)
            navigationButtons(
                mainViewModel = mainViewModel,
                context = context,
                lessonId = lessonId,
                moduleId = moduleId,
                moduleItemsSize = size
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


private fun LazyListScope.navigationButtons(
    mainViewModel: MainViewModel,
    context: Context,
    lessonId: MutableState<Int>,
    moduleId: Int,
    moduleItemsSize: Int
) {

    item {
        Row {
            val isFirstLesson = lessonId.value == 0
            val isLastLesson = lessonId.value == moduleItemsSize
            val isMiddleLesson = lessonId.value in 1 until moduleItemsSize

            if (isLastLesson || isMiddleLesson) {  // lessonId > 0 AND lessonId <= num1
                BackButton {
                    lessonId.value -= 1
                    updateContent(mainViewModel, context, lessonId, moduleId)
                }
            }

            if (isFirstLesson || isMiddleLesson) {  // lessonId >= 0 AND lessonId <= num1
                NextButton() {
                    lessonId.value += 1
                    updateContent(mainViewModel, context, lessonId, moduleId)
                }
            }


        }
    }
}

@Composable
private fun NextButton(
    onUpdate: () -> Unit
) {
    Button(
        onClick = onUpdate
    ) {
        Text(text = "Вперёд")
    }
}

@Composable
private fun BackButton(
    onUpdate: () -> Unit
) {
    Button(
        onClick = onUpdate
    ) {
        Text(text = "Назад")
    }
}

private fun updateContent(
    mainViewModel: MainViewModel,
    context: Context,
    lessonId: MutableState<Int>,
    moduleId: Int
) {
    mainViewModel.fetchLessonData(
        context = context,
        id = lessonId.value,
        dataType = DataType.LESSON,
        moduleId = moduleId
    )
}

