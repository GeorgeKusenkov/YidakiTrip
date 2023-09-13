package com.example.yidakitrip.items

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.unit.dp
import com.example.yidakitrip.R
import com.example.yidakitrip.model.ModuleItemList
import com.example.yidakitrip.ui.theme.Typography

@Composable
fun ModuleItem(moduleItemList: ModuleItemList, onClick:(ModuleItemList) -> Unit)  {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(dimensionResource(id = R.dimen.card_padding))
            .clickable { onClick(moduleItemList) }
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
                text = moduleItemList.title,
                color = Color.Black,
                fontSize = Typography.headlineMedium.fontSize,
            )
            Text(
                text = "${moduleItemList.description}",
                color = Color.Black,
                fontSize = Typography.headlineSmall.fontSize,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}