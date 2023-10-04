package com.example.yidakitrip.presentation.item

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.yidakitrip.Utils
import com.example.yidakitrip.data.model.ItemContent

@Composable
fun LessonItem(moduleItemList: ItemContent, contentOnClick:(ItemContent) -> Unit) {
    Surface(modifier = Modifier.padding(12.dp, 8.dp)) {
        BasicItem(
            imagePainter = painterResource(id = Utils.getResourceIdByName(moduleItemList.image)),
            title = moduleItemList.title,
            description = moduleItemList.description,
            allProgress = 10,
            passedProgress = 2,
            lessonRating = 1,
            itemContent = moduleItemList,
            contentOnClick = contentOnClick
        )
    }



//    Card(
//        shape = RoundedCornerShape(16.dp),
//        modifier = Modifier
//            .fillMaxWidth()
//            .fillMaxHeight()
//            .padding(dimensionResource(id = R.dimen.card_padding))
//            .clickable { onClick(lessonItemList) }
//    ) {
//        Row(
//            modifier = Modifier
//                .background(Color.LightGray)
//                .fillMaxWidth()
//                .padding(24.dp),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.spacedBy(12.dp)
//        ) {
//            Text(
//                text = lessonItemList.title,
//                color = Color.Black,
//                fontSize = Typography.headlineMedium.fontSize,
//            )
//            Text(
//                text = "${lessonItemList.description}",
//                color = Color.Black,
//                fontSize = Typography.headlineSmall.fontSize,
//                fontWeight = FontWeight.Bold,
//            )
//        }
//    }
}