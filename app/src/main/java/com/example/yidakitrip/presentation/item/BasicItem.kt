package com.example.yidakitrip.presentation.item

import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.yidakitrip.R
import com.example.yidakitrip.Utils
import com.example.yidakitrip.data.model.ItemContent
import com.example.yidakitrip.presentation.theme.YidakiTripTheme

@Composable
fun BasicItem(
    imagePainter: Painter,
    title: String,
    description: String,
    allProgress: Int,
    passedProgress: Int,
    lessonRating: Int,
    itemContent: ItemContent,
    contentOnClick: (ItemContent) -> Unit,
) {
    val passed = allProgress == passedProgress
    val icon = if (passed) Icons.Default.Refresh else Icons.Default.KeyboardArrowRight
    val buttonText = if (passed)
        stringResource(id = R.string.repeat_button_text)
    else
        stringResource(id = R.string.continue_button_text)
    val progressIndicatorValue = (passedProgress.toFloat() / allProgress.toFloat())


    Card(
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.card_rounded_corner)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            ImageSection(imagePainter)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(0xFFF2E4DD))
            ) {
                Image(
                    painter = painterResource(id = R.drawable.mask),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    alpha = 0.3F,
                    modifier = Modifier.matchParentSize()
                )
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    TextSection(title, passedProgress, allProgress, lessonRating)
                    DescriptionSection(description)
                    ProgressButton(
                        progressIndicatorValue,
                        buttonText,
                        icon,
                        contentOnClick,
                        itemContent
                    )
                    Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.card_spacer)))
                }
            }
        }
    }
}

@Composable
fun ImageSection(
    image: Painter
) {
    Image(
        modifier = Modifier
            .height(dimensionResource(id = R.dimen.basic_item_image_height))
            .fillMaxWidth(),
        painter = image,
        contentScale = ContentScale.FillWidth,
        contentDescription = "Main image"
    )
}

@Composable
private fun TextSection(title: String, passedProgress: Int, allProgress: Int, lessonRating: Int) {
    val progressText = stringResource(R.string.progress_text, passedProgress, allProgress)
    Row(
        modifier = Modifier
            .padding(
                start = dimensionResource(id = R.dimen.basic_item_horizontal_padding),
                top = dimensionResource(id = R.dimen.text_section_top_padding),
                end = dimensionResource(id = R.dimen.basic_item_horizontal_padding),
                bottom = dimensionResource(id = R.dimen.basic_item_vertical_padding)
            )
            .fillMaxWidth(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Absolute.SpaceBetween
    ) {
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        if (passedProgress == allProgress) {
            RatingBar(current = lessonRating)
        } else {
            Text(
                text = progressText,
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
private fun DescriptionSection(description: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = dimensionResource(id = R.dimen.basic_item_horizontal_padding),
                vertical = dimensionResource(id = R.dimen.description_section_vertical_padding)
            ),
        color = MaterialTheme.colorScheme.secondary,
        text = description,
        fontSize = 13.sp,
        lineHeight = 18.sp,
        maxLines = 5
    )
}

@Composable
private fun ProgressButton(
    progressIndicatorValue: Float,
    buttonText: String,
    icon: ImageVector,
    contentOnClick: (ItemContent) -> Unit,
    itemContent: ItemContent,
) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center,
    ) {
        LinearProgressIndicator(
            modifier = Modifier
                .padding(
                    horizontal = dimensionResource(id = R.dimen.basic_item_horizontal_padding),
                    vertical = dimensionResource(id = R.dimen.basic_item_vertical_padding),
                )
                .fillMaxWidth()
                .height(dimensionResource(id = R.dimen.progress_button_height))
                .clip(RoundedCornerShape(dimensionResource(id = R.dimen.button_rounded_corner)))
                .clickable { contentOnClick(itemContent) },
            progress = progressIndicatorValue,
            color = MaterialTheme.colorScheme.tertiary,
            trackColor = MaterialTheme.colorScheme.primary
        )
        Row {
            Text(text = buttonText)
            Image(
                imageVector = icon,
                contentDescription = "icon"
            )
        }
    }
}

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    current: Int = 0,
    onRatingChanged: (Int) -> Unit = {}
) {
    val curRating by remember { mutableIntStateOf(current) }

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(3.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (index in 1..5) {
            Icon(
                imageVector = if (index <= curRating) Icons.Filled.Star else Icons.Outlined.StarBorder,
                contentDescription = null,
                modifier = Modifier
//                    .clickable {
//                        curRating = index
//                        onRatingChanged(index)
//                    }
                    .size(20.dp)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun BasicItemPreview() {
    YidakiTripTheme {
        BasicItem(
            imagePainter = painterResource(id = Utils.getResourceIdByName("imag_c1m1")),
            title = "Sample Title",
            description = "Sample Description",
            allProgress = 10,
            passedProgress = 10,
            lessonRating = 4,
            itemContent = ItemContent(
                id = "MODULE-1",
                title = "Вступление",
                description = "В этом модуле вы узнаете азы игры на диджейриду, научитесь извлекать первые звуки",
                image = "imag_c1m1"
            ),
            contentOnClick = {} // заглушка - пустая функция
        )
    }
}