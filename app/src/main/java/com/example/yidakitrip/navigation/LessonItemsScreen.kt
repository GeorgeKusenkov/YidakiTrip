package com.example.yidakitrip.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.yidakitrip.items.LessonItem
import com.example.yidakitrip.repository.TestModules

@Composable
fun LessonItemsScreen(
    text: String,
    navController: NavController
) {

    val lessonItems = TestModules().getModule(text.toInt())

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {
            itemsIndexed(items = lessonItems) { index: Int, lesson ->
                LessonItem(lesson, onClick = {
                    navController.navigate(
                        route = Screen.LessonDetailed.passId(
                            id = 1,
                            name = "${text}${index + 1}"
                        )
                    )
                }
                )
            }
        }
    }
}