package com.example.yidakitrip.items.characters

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.yidakitrip.R
import com.example.yidakitrip.ui.theme.Orange40

@Composable
fun CharacterShamanItem(text: String) {
    CharacterCard(
        text = text,
        avatar = painterResource(id = R.drawable.dialog_img_shaman),
        avatarBackgroundColor = Orange40,
        contentDescription= "Shaman image avatar",
        dialogBorderStrokeColor = Orange40
    )
}

//fun CharacterShamanItem(course: Course, onClick: (Course) -> Unit) {
//    Card(
//        shape = RoundedCornerShape(16.dp),
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(dimensionResource(id = R.dimen.card_padding))
//            .clickable { onClick(course) }
//    ) {
//        Row(
//            modifier = Modifier
//                .background(MaterialTheme.colorScheme.primary)
//                .fillMaxWidth()
//                .padding(15.dp),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.Start
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.dialog_img_shaman),
//                contentDescription = "Shaman image avatar",
//                modifier = Modifier
//                    .size(64.dp)
//                    .clip(CircleShape)
//                    .border(2.dp, Color.LightGray, CircleShape)
//                    .background(MaterialTheme.colorScheme.secondary)
//            )
//            Spacer(modifier = Modifier.width(10.dp))
//            Text(
//                text = course.description,
//                color = MaterialTheme.colorScheme.background
//            )
//        }
//
//    }
//}

@Composable
@Preview(showBackground = true)
fun CharacterShamanItemPreview() {
    CharacterShamanItem("awefwafgawgawg")
}