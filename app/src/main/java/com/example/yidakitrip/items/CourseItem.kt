package com.example.yidakitrip.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.yidakitrip.R
import com.example.yidakitrip.model.CourseItemList
import com.example.yidakitrip.ui.theme.Typography

@Composable
fun CourseItem(courseItemList: CourseItemList) {

    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.card_padding))
    ) {
        Row(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth()
                .padding(24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "${courseItemList.id}",
                color = Color.Black,
                fontSize = Typography.displayMedium.fontSize,
                fontWeight = FontWeight.Bold
            )
            Text(
               text = "${courseItemList.title}",
               color = Color.Black,
               fontSize = Typography.headlineMedium.fontSize,
           )
            Text(
                text = "${courseItemList.description}",
                color = Color.Black,
                fontSize = Typography.headlineSmall.fontSize,
                fontWeight = FontWeight.Bold,
            )
        }
    }

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
