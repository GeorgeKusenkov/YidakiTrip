package com.example.yidakitrip.presentation.navigation.screen.bottommenu

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.yidakitrip.presentation.navigation.BottomBarScreen
import com.example.yidakitrip.presentation.navigation.DetailsScreen
import com.example.yidakitrip.presentation.navigation.screen.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseScreen(navController: NavHostController, mainViewModel: MainViewModel) {
    LaunchedEffect(Unit){
        mainViewModel.setTitle("Курсы")
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
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
                    route = DetailsScreen.Course.passId(1, "0")
                )
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