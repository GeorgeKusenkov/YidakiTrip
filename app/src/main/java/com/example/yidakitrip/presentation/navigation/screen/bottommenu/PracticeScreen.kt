package com.example.yidakitrip.presentation.navigation.screen.bottommenu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.yidakitrip.presentation.navigation.screen.MainViewModel

@Composable
fun PracticeScreen(mainViewModel: MainViewModel) {
    LaunchedEffect(Unit){
        mainViewModel.setTitle("Практика")
    }

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text(text = "PracticeScreen")
    }
}