package com.example.yidakitrip.navigation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.yidakitrip.items.ModuleItem
import com.example.yidakitrip.model.ModuleItemList
import com.example.yidakitrip.navigation.graph.DetailsScreen
import com.example.yidakitrip.repository.module.ModulesRepository

@Composable
fun ModuleItemsScreen(
    text: String,
    navController: NavController
) {
    val courseRepository = ModulesRepository()

    val getCourseData = when(text) {
        "COURSE-1" -> courseRepository.getCourseOneModules()
        "COURSE-2" -> courseRepository.getCourseTwoModules()
        else -> emptyList()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {
            itemsIndexed(items = getCourseData) { index: Int, module ->
//                 ModuleItem(module) { toDetail(navController = navController, module = module) }
                ModuleItem(module, onClick = {
                    navController.navigate(
                        route = DetailsScreen.Module.passId(
                            id = 1,
                            name = "${index+1}"
                        )
                    )
                }

                )
            }
        }

//        Text(
//            modifier = Modifier.clickable {
//                navController.navigate(route = Screen.Main.route) {
//                    popUpTo(Screen.Main.route) {
//                        inclusive = true
//                    }
//                }
////                navController.popBackStack()
//            },
//            text = "Course",
//            color = Color.Red,
//            fontSize = MaterialTheme.typography.displayLarge.fontSize,
//            fontWeight = FontWeight.Bold
//        )
    }

}
private fun toDetail(
    navController: NavController,
    moduleItemList: ModuleItemList
) {
    navController.navigate(
        route = DetailsScreen.Module.passId(
            id = 1,
            name = moduleItemList.id
        )
    )
}
@Composable
@Preview(showBackground = true)
fun CourseScreenPreview() {
    ModuleItemsScreen(text = "rememberNavController()", navController = rememberNavController())
}