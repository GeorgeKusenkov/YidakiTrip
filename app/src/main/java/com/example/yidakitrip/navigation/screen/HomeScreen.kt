package com.example.yidakitrip.navigation.screen

import android.util.Log
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.yidakitrip.navigation.BottomBarScreen
import com.example.yidakitrip.navigation.graph.HomeNavGraph

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
//    navController: NavController
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) {
        HomeNavGraph(navController = navController)
    }











//
//
//    var text by remember {
//        mutableStateOf("")
//    }
//
//    val items = listOf(
//        BottomNavigationItem(
//            tittle = "study",
//            selectedIcon = Icons.Filled.Home,
//            unSelectedIcon = Icons.Outlined.Home
//        ),
//        BottomNavigationItem(
//            tittle = "profile",
//            selectedIcon = Icons.Filled.Person,
//            unSelectedIcon = Icons.Outlined.Person
//        ),
//        BottomNavigationItem(
//            tittle = "practice",
//            selectedIcon = Icons.Filled.PlayArrow,
//            unSelectedIcon = Icons.Outlined.PlayArrow
//        ),
//        BottomNavigationItem(
//            tittle = "about",
//            selectedIcon = Icons.Filled.Face,
//            unSelectedIcon = Icons.Outlined.Face
//        )
//    )
//
//    var selectedItemIndex by rememberSaveable {
//        mutableStateOf(0)
//    }
//                    Scaffold(
//                        bottomBar = {
//                            NavigationBar {
//                                items.forEachIndexed { index, item ->
//                                    NavigationBarItem(
//                                        selected = selectedItemIndex == index,
//                                        onClick = {
//                                            selectedItemIndex = index
//                                            Log.d("TEEEEST",item.tittle)
//                                            navController.navigate(item.tittle)
//                                        },
//                                        icon = {
//                                                Icon(
//                                                    imageVector = if (index == selectedItemIndex) {
//                                                        item.selectedIcon
//                                                    } else {
//                                                        item.unSelectedIcon
//                                                    },
//                                                    contentDescription = item.tittle
//                                                )
//                                        })
//                                }
//                            }
//                        }
//                    ) {
//
//                    }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(20.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally,
//        ) {
//        Card(
//            shape = RoundedCornerShape(16.dp),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(20.dp)
//                .height(100.dp),
//            onClick = {
//                navController.navigate(
//                    route = Screen.Course.passId(1, "COURSE-1")
//                )
////                navController.navigate(
////                    route = BottomBarScreen.Profile.route
////                )
//                Log.d("TEEEEST", BottomBarScreen.Profile.route)
//            }
//        ) {
//            Column(
//                modifier = Modifier.fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ){
//                Text(text = "To Modules")
//            }
//        }
//    }

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

    val bottomBarDestination = screens.any {it.route == currentDestination?.route}
    if (bottomBarDestination) {
        NavigationBar {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }  
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    NavigationBarItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            Log.d("TEEEEST", screen.route)
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}