package com.example.yidakitrip.presentation.item.characters

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.yidakitrip.R
import com.example.yidakitrip.presentation.theme.Orange40

@Composable
fun CharacterCard(
    text: String,
    avatar: Painter,
    avatarBackgroundColor: Color,
    contentDescription: String,
    dialogBorderStrokeColor: Color
) {

    val absRoundedCornerShape = AbsoluteRoundedCornerShape(
        topLeftPercent = 50,
        topRightPercent = 50,
        bottomLeftPercent = 50,
        bottomRightPercent = 10
    )
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.End
    ) {
        Image(
            painter = avatar,
            contentDescription = contentDescription,
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.min_card_height))
                .clip(CircleShape)
                .background(avatarBackgroundColor)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            modifier = Modifier
                .defaultMinSize(dimensionResource(id = R.dimen.min_card_height))
                .weight(1F, true),
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(2.dp, dialogBorderStrokeColor)
        ) {
            Text(
                modifier = Modifier.padding(20.dp, 12.dp),
                text = text
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CharacterCardPreview() {
    CharacterCard(
        text = "Luka image avatar",
        avatar = painterResource(id = R.drawable.dialog_img_luka),
        avatarBackgroundColor = Orange40,
        contentDescription= "Luka image avatar",
        dialogBorderStrokeColor = Orange40
    )
}