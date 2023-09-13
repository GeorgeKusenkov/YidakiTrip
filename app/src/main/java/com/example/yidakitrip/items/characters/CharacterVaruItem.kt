package com.example.yidakitrip.items.characters

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.yidakitrip.R
import com.example.yidakitrip.ui.theme.Orange40

@Composable
fun CharacterVaruItem(text: String) {
    CharacterCard(
        text = text,
        avatar = painterResource(id = R.drawable.dialog_img_varu),
        avatarBackgroundColor = Orange40,
        contentDescription= "Varu image avatar",
        dialogBorderStrokeColor = Orange40
    )
}

@Composable
@Preview(showBackground = true)
fun CharacterVaruItemPreview() {
    CharacterVaruItem("awefwafgawgawg")
}