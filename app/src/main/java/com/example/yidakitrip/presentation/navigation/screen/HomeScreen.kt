package com.example.yidakitrip.presentation.navigation.screen

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.yidakitrip.presentation.navigation.BottomBarScreen
import com.example.yidakitrip.presentation.navigation.MainViewModelFactory
import com.example.yidakitrip.presentation.navigation.graph.HomeNavGraph
import com.example.yidakitrip.presentation.navigation.screen.moduleItems.DataType

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController = rememberNavController(),
) {
    val context = LocalContext.current
    val mainViewModel: MainViewModel = viewModel(
        factory = MainViewModelFactory(context)
    )

    val roomViewModel: RoomViewModel = viewModel(factory = RoomViewModel.factory)

    val title: String by mainViewModel.screenTitle.observeAsState("Home")


    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val destination = currentBackStackEntry?.destination?.route.toString()


    //Получаем все данные
//    mainViewModel.fetchContentData(id = "0", dataType = DataType.ALL)
    mainViewModel.getAllFileNamesData(0, dataType = DataType.ALL)
    val moduleNames by mainViewModel.allNameList.observeAsState(emptyList())
    //Отправляем их в БД
    roomViewModel.loadAllDataToRoom(moduleNames)
    Log.d("12312312333", "moduleNames: ${moduleNames}")


    Scaffold(
        topBar = {
            when (destination) {
                Destination.STUDY -> SetHomeTopBar(navController, title)
                Destination.PROFILE -> SetHomeTopBar(navController, title)
                Destination.PRACTICE -> SetHomeTopBar(navController, title)
                Destination.ABOUT -> SetHomeTopBar(navController, title)
                Destination.COURSE -> SetDetailsTopBar(navController, title)
                Destination.MODULE -> SetDetailsTopBar(navController, title)
                Destination.LESSON -> SetDetailsTopBar(navController, title)
            }
        },
        bottomBar = { BottomBar(navController = navController) },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding())) {
            HomeNavGraph(navController = navController, mainViewModel)
        }
    }
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
@OptIn(ExperimentalMaterial3Api::class)
private fun SetHomeTopBar(navController: NavHostController, title: String) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = title)
        },
        actions = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "settings icon"
                )
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
        )
    )
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun SetDetailsTopBar(navController: NavHostController, title: String) {
    CenterAlignedTopAppBar(
        title = {
            Text(text = title)
        },
        actions = {
            IconButton(onClick = { /* do something */ }) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription = "Localized description"
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "Icon Menu")
            }
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
        )
    )
}

//@Composable
//@Preview(showBackground = true)
//fun MainScreenPreview() {
//    HomeScreen(
//        navController = rememberNavController()
//    )
//}

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
        NavigationBar(
//            containerColor = Color.Red,
            tonalElevation = 100.dp,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(25.dp, 25.dp, 0.dp, 0.dp))
        ) {
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

object Destination {
    const val STUDY = "study_screen"
    const val PROFILE = "profile"
    const val PRACTICE = "practice"
    const val ABOUT = "about"
    const val COURSE = "course_screen/{id}/{name}"
    const val MODULE = "module_screen/{id}/{name}"
    const val LESSON = "lesson_detailed_screen/{id}/{name}/{is_first}/{is_last}"

}
