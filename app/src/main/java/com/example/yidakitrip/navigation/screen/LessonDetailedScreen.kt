package com.example.yidakitrip.navigation.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.yidakitrip.items.LessonImage
import com.example.yidakitrip.items.LessonElement
import com.example.yidakitrip.items.characters.CharacterLukaItem
import com.example.yidakitrip.items.characters.CharacterVaruItem
import com.example.yidakitrip.model.Lesson
import com.example.yidakitrip.repository.lesson.LessonRepository

@Composable
fun LessonDetailedScreen(
    text: String,
) {
    val lessonId = remember {
        mutableStateOf(text.toInt())
    }
//    val lessonContentList = remember {
//        mutableStateOf(LessonRepository().getLessons(text.toInt()))
//    }

    val newLessonContentList = remember {
        mutableStateOf(LessonRepository().getNewLessons(text.toInt()))
    }

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            content(newLessonContentList)
            buttons(lessonId, newLessonContentList)
        }
    }
}
private fun LazyListScope.content(lessonContent: MutableState<Lesson>) {
    val contentElements = lessonContent.value.lessonContent
    items(items = contentElements) { element ->
        when (element.type) {
            LessonElement.TEXT -> Text(element.text)
            LessonElement.LUKA -> CharacterLukaItem(element.text)
            LessonElement.VARU -> CharacterVaruItem(element.text)
            LessonElement.IMAGE -> LessonImage(id = element.text.toInt())
            else -> Text(element.text)
        }
    }
}

private fun LazyListScope.buttons(
    lessonId: MutableState<Int>,
    lessonContent: MutableState<Lesson>
) {
    val isFirstLesson = lessonContent.value.isFirstLesson
    val isLastLesson = lessonContent.value.isLastLesson

    item {
        Row {
            if (isFirstLesson) {
                nextButton(lessonId, lessonContent)
            } else if (isLastLesson) {
                backButton(lessonId, lessonContent)
            } else {
                backButton(lessonId, lessonContent)
                nextButton(lessonId, lessonContent)
            }
        }
    }
}

@Composable
private fun nextButton(
    lessonId: MutableState<Int>,
    lessonContent: MutableState<Lesson>
) {
    Button(
        onClick = {
            lessonId.value++
            updateContent(lessonContent, lessonId)
            Log.d("TEEEEST", "id:${lessonId.value}")
        }
    ) {
        Text(text = "Вперед")
    }
}

@Composable
private fun backButton(
    lessonId: MutableState<Int>,
    lessonContent: MutableState<Lesson>
) {
    Button(
        onClick = {
            lessonId.value--
            updateContent(lessonContent, lessonId)
            Log.d("TEEEEST", "id:${lessonId.value}")
        }
    ) {
        Text(text = "Назад")
    }
}

private fun updateContent(
    lessonContent: MutableState<Lesson>,
    lessonId: MutableState<Int>
) {
    lessonContent.value = LessonRepository().getNewLessons(lessonId.value)
}

