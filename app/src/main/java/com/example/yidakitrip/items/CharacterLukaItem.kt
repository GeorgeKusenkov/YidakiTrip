package com.example.yidakitrip.items

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.yidakitrip.R
import com.example.yidakitrip.Screen
import com.example.yidakitrip.model.Course

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterLukaItem(course: Course, onClick: (Course) -> Unit) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.card_padding))
            .clickable { onClick(course) }
    ) {
        Row(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .fillMaxWidth()
                .padding(15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = painterResource(id = R.drawable.dialog_img_luka),
                contentDescription = "Luka image avatar",
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Green, CircleShape)
                    .background(Color.Red)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = course.description,
            )
        }

    }
}

@Composable
@Preview(showBackground = true)
fun CharacterLukaItemPreview() {
//    CharacterLukaItem(Course(1, "", ""), )
}

@Composable
fun Item1(course: Course, onClick: (Course) -> Unit) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.card_padding))
            .clickable { onClick(course) },
    ) {
        //any code
    }
}