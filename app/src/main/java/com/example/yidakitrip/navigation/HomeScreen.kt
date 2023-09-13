package com.example.yidakitrip.navigation

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.yidakitrip.BottomNavigationItem
import com.example.yidakitrip.navigation.bottomNavigation.BottomBarScreen
import com.example.yidakitrip.navigation.bottomNavigation.BottomNavGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController
) {


    var text by remember {
        mutableStateOf("")
    }

    val items = listOf(
        BottomNavigationItem(
            tittle = "study",
            selectedIcon = Icons.Filled.Home,
            unSelectedIcon = Icons.Outlined.Home
        ),
        BottomNavigationItem(
            tittle = "profile",
            selectedIcon = Icons.Filled.Person,
            unSelectedIcon = Icons.Outlined.Person
        ),
        BottomNavigationItem(
            tittle = "practice",
            selectedIcon = Icons.Filled.PlayArrow,
            unSelectedIcon = Icons.Outlined.PlayArrow
        ),
        BottomNavigationItem(
            tittle = "about",
            selectedIcon = Icons.Filled.Face,
            unSelectedIcon = Icons.Outlined.Face
        )
    )

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
                    Scaffold(
                        bottomBar = {
                            NavigationBar {
                                items.forEachIndexed { index, item ->
                                    NavigationBarItem(
                                        selected = selectedItemIndex == index,
                                        onClick = {
                                            selectedItemIndex = index
                                            Log.d("TEEEEST",item.tittle)
                                            navController.navigate(item.tittle)
                                        },
                                        icon = {
                                                Icon(
                                                    imageVector = if (index == selectedItemIndex) {
                                                        item.selectedIcon
                                                    } else {
                                                        item.unSelectedIcon
                                                    },
                                                    contentDescription = item.tittle
                                                )
                                        })
                                }
                            }
                        }
                    ) {

                    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(100.dp),
            onClick = {
                navController.navigate(
                    route = Screen.Course.passId(1, "COURSE-1")
                )
//                navController.navigate(
//                    route = BottomBarScreen.Profile.route
//                )
                Log.d("TEEEEST", BottomBarScreen.Profile.route)
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
    }
}

@Composable
@Preview(showBackground = true)
fun MainScreenPreview() {
    HomeScreen(
        navController = rememberNavController()
    )
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Study,
        BottomBarScreen.Profile,
        BottomBarScreen.Practice,
        BottomBarScreen.About,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

}