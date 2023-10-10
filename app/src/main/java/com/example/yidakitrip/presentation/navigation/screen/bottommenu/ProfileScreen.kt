package com.example.yidakitrip.presentation.navigation.screen.bottommenu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.example.yidakitrip.presentation.navigation.screen.MainViewModel

@Composable
fun ProfileScreen(mainViewModel: MainViewModel) {
        LaunchedEffect(Unit){
            mainViewModel.setTitle("Профиль")
        }
        Column(modifier = Modifier
            .fillMaxSize()
        ) {
            Text(text = "ProfileScreen")
        }

}