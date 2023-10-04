package com.example.yidakitrip

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.yidakitrip.presentation.navigation.graph.RootNavGraph
import com.example.yidakitrip.presentation.theme.YidakiTripTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YidakiTripTheme {
                RootNavGraph(navController = rememberNavController())
            }
        }
    }
}
