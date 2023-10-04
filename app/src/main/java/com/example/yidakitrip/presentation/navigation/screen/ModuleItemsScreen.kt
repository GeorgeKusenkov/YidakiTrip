package com.example.yidakitrip.presentation.navigation.screen

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.yidakitrip.presentation.item.ModuleItem
import com.example.yidakitrip.presentation.navigation.DetailsScreen

enum class DataType {
    COURSE,
    MODULE,
    LESSON
}
@Composable
fun ModuleItemsScreen(
    mainViewModel: MainViewModel, text: String, navController: NavController
) {

    val context = LocalContext.current
    LaunchedEffect(Unit) {
        mainViewModel.setTitle("Модули")
        mainViewModel.fetchContentData(context = context, id = text, dataType = DataType.COURSE)
    }

    //FROM JSON IN ASSETS
//    val assetFileNames = getAssetFileNames(context, "courseinfo") //список всех файлов
//    val elementInfo = getClassFiles(context, DataType.COURSE)               //список имен модулей
//    val nessesaryJsonFile = readJsonFile(context, elementInfo[text.toInt()])

    val moduleItems by mainViewModel.moduleItems.observeAsState(emptyList())

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {
            itemsIndexed(items = moduleItems) { index: Int, module ->
                ModuleItem(module, contentOnClick = {
                    navController.navigate(
                        route = DetailsScreen.Module.passId(
                            id = 1, name = index.toString()
                        )
                    )
                })
            }
        }
    }
}
//
//fun getIndexedElement(index: Int, listData: List<String>): String {
//    return listData[index]
//}
//fun getClassFiles(context: Context, dataType: DataType): List<String> {
//    val listData = getAssetFileNames(context, "courseinfo")
//    val regex = Regex("data_")
//
//    val course = mutableListOf<String>()
//    val module = mutableListOf<String>()
//    val lesson = mutableListOf<String>()
//
//    listData.forEach { filename ->
//        val fields = filename.replace(regex, "").split("_")
//        when(fields.size) {
//            1 -> course.add(filename)
//            2 -> module.add(filename)
//            3 -> lesson.add(filename)
//        }
//    }
//    return when(dataType) {
//        DataType.COURSE -> course
//        DataType.MODULE -> module
//        DataType.LESSON -> lesson
//    }
//}
//
//fun getAssetFileNames(context: Context, folderName: String): List<String> {
//    val assetManager = context.assets
//    val fileNames = mutableListOf<String>()
//    try {
//        val files = assetManager.list(folderName)
//        if (files != null) {
//            for (fileName in files) {
//                fileNames.add(fileName)
//            }
//        }
//    } catch (e: IOException) {
//        e.printStackTrace()
//    }
//
//    return fileNames
//}
//
//fun readJsonFile(context: Context, filename: String): List<ContentItem> {
//    val json = context.assets.open("courseinfo/$filename").bufferedReader().use { it.readText() }
//    val itemType = object : TypeToken<List<ContentItem>>() {}.type
//    return Gson().fromJson(json, itemType)
//}
@Composable
@Preview(showBackground = true)
fun CourseScreenPreview() {
//    ModuleItemsScreen(text = "rememberNavController()", navController = rememberNavController())
}