package com.example.yidakitrip.presentation.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.yidakitrip.R

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