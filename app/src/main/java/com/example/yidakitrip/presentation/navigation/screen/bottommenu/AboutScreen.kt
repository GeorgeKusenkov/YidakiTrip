package com.example.yidakitrip.presentation.navigation.screen.bottommenu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.example.yidakitrip.presentation.navigation.screen.MainViewModel

@Composable
fun AboutScreen(mainViewModel: MainViewModel) {
    LaunchedEffect(Unit) { mainViewModel.setTitle("О нас") }
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "AboutScreen")
    }
}



