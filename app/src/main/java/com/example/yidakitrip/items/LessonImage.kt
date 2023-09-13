package com.example.yidakitrip.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.yidakitrip.R
import com.example.yidakitrip.navigation.ModuleItemsScreen

@Composable
fun LessonImage(id: Int) {
    Image(
        painter = painterResource(id = id),
        contentDescription = "Luka image avatar",
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))

    )
}

@Composable
@Preview(showBackground = true)
fun LessonImagePreview() {
    LessonImage(R.drawable.img_lesson_c1m1l1_1)
}