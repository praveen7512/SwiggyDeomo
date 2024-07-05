package com.example.swiggydeomo.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun DetailScreen(title: String, decription: String, imageUrl: String) {
    Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        Alignment.CenterHorizontally
    ) {

        Card(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .wrapContentSize(),
            shape = RoundedCornerShape(16.dp)
        ) {

            val imageUrlResource = rememberAsyncImagePainter(model = imageUrl)
            Image(
                painter = imageUrlResource,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier.clip(RoundedCornerShape(10.dp))
            )

            Text(text = title, style = MaterialTheme.typography.bodySmall, maxLines = 1)
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = decription, style = MaterialTheme.typography.bodySmall, maxLines = 2)


        }
    }

}