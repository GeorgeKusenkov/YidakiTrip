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
fun ContentItemCard(
    contentItemList: ItemContent,
    contentItemSize: Int,
    passedProgress: Int,
    rating: Int,
    contentOnClick:(ItemContent) -> Unit) {
    Surface(modifier = Modifier.padding(12.dp, 8.dp)) {
        BasicItem(
            imagePainter = painterResource(id = Utils.getResourceIdByName(contentItemList.image)),
            title = contentItemList.title,
            description = contentItemList.description,
            allProgress = contentItemSize,
            passedProgress = passedProgress,
            lessonRating = rating,
            itemContent = contentItemList,
            contentOnClick = contentOnClick
        )
    }
}

//
//    Card(
//        shape = RoundedCornerShape(16.dp),
//        modifier = androidx.compose.ui.Modifier
//            .fillMaxWidth()
//            .fillMaxHeight()
//            .padding(dimensionResource(id = R.dimen.card_padding))
//            .clickable { onClick(moduleItemList) }
//    ) {
//        Row(
//            modifier = androidx.compose.ui.Modifier
//                .fillMaxWidth()
//                .padding(24.dp),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.spacedBy(12.dp)
//        ) {
//            Text(
//                text = moduleItemList.title,
//                color = Color.Black,)
//            Text(
//                text = moduleItemList.description,
//                color = Color.Black,
//                fontWeight = FontWeight.Bold,
//            )
//        }
//    }


//@Composable
//@Preview(showBackground = true)
//fun ModuleItemPreview() {
//    ModuleItem(
//        ModuleItemList(
//            "1",
//            "Basic course",
//            "learn about didgeridoo and",
//            1
//        )
//    )
//}