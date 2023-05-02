package com.example.bookSearchApp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.bookSearchApp.domain.model.BookModel


@Composable
fun BookItemView(bookModel: BookModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            val painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(bookModel.image)
                    .crossfade(true)
                    .build()
            )

            Image(
                painter = painter,
                contentScale = ContentScale.Crop,
                contentDescription = "Picture of a user"
            )
            Column(){
                Text(
                    text = "제목 : "+bookModel.title,
                    modifier = Modifier.padding(start = 8.dp)
                )
                Text(
                    text = "저자 : "+bookModel.author,
                    modifier = Modifier.padding(start = 8.dp)
                )
                Text(
                    text = "출판사 : "+bookModel.publisher,
                    modifier = Modifier.padding(start = 8.dp)
                )
                Text(
                    text = "가격 : "+bookModel.discount,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }


        }
    }
}