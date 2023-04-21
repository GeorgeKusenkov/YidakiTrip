package com.example.yidakitrip.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.yidakitrip.model.Course
import com.example.yidakitrip.ui.theme.Typography

@Composable
fun CourseItem(course: Course) {
    Row(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "${course.id}",
            color = Color.Black,
            fontSize = Typography.displayMedium.fontSize,
            fontWeight = FontWeight.Bold
        )
        Text(
           text = "${course.title}",
           color = Color.Black,
           fontSize = Typography.headlineMedium.fontSize,
       )
//        Text(
//            text = "${course.description}",
//            color = Color.Black,
//            fontSize = Typography.headlineSmall.fontSize,
//            fontWeight = FontWeight.Bold,
//        )
    }
}

@Composable
@Preview(showBackground = true)
fun CourseItemPreview() {
    CourseItem(
        Course(
            "1",
            "Basic course",
            "learn about didgeridoo and"
        )
    )
}
