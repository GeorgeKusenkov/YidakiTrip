package com.example.yidakitrip.presentation.item

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.yidakitrip.data.model.CourseItemList

@Composable
fun CourseItem(courseItemList: CourseItemList) {
//    BasicItem(
//        title = courseItemList.title,
//        description = courseItemList.description,
//        allProgress = 5,
//        passedProgress = 0
//    )
}

@Composable
@Preview(showBackground = true)
fun CourseItemPreview() {
    CourseItem(
        CourseItemList(
            "1",
            "Basic course",
            "learn about didgeridoo and"
        )
    )
}
