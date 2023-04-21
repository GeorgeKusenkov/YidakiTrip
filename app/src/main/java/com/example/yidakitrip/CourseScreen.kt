package com.example.yidakitrip

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun CourseScreen(
    text: String
//    navController: NavController
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
            Text(text = text)
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

@Composable
@Preview(showBackground = true)
fun CourseScreenPreview() {
    CourseScreen(text = "rememberNavController()")
}