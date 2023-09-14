package com.example.yidakitrip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.yidakitrip.navigation.graph.RootNavGraph
import com.example.yidakitrip.ui.theme.YidakiTripTheme

//data class BottomNavigationItem(
//    val tittle: String,
//    val selectedIcon: ImageVector,
//    val unSelectedIcon: ImageVector
//)

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

//    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YidakiTripTheme {
                RootNavGraph(navController = rememberNavController())
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    navController = rememberNavController()
//                    SetupNavGraph(navController = navController)
//                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}