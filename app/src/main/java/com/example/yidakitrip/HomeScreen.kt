package com.example.yidakitrip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.yidakitrip.items.CharacterLukaItem
import com.example.yidakitrip.items.CharacterShamanItem
import com.example.yidakitrip.model.Course
import com.example.yidakitrip.repository.CourseRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController
) {

    var text by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        val courseRepository = CourseRepository()
        val getAllData = courseRepository.getAllData()

//        TextField(value = text, onValueChange = {
//            text = it
//        })
//        Spacer(modifier = Modifier.height(10.dp))
//        Button(onClick = {
//            navController.navigate(
//                route = Screen.Course.passId(
//                    id = 10,
//                    name = text
//                )
//            )
//        }) {
//            Text(text = "Main", fontWeight = FontWeight.Bold)
//        }


        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(100.dp),
            onClick = {
                navController.navigate(
                    route = Screen.Course.passId(1, "COURSE-1 ")
                )
            }
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(text = "To Modules")
            }

        }

//        LazyColumn {
//            items(items = getAllData) { course ->
//                when (course.id) {
//                    "1" -> CharacterLukaItem(course) { toDetail(navController, course) }
//                    "2" -> CharacterShamanItem(course) { toDetail(navController, course) }
//                }
//            }
//        }

    }
}

private fun toDetail(
    navController: NavController,
    course: Course
) {
    navController.navigate(
        route = Screen.Course.passId(
            id = 1,
            name = course.id
        )
    )
}

@Composable
@Preview(showBackground = true)
fun MainScreenPreview() {
    HomeScreen(
        navController = rememberNavController()
    )
}