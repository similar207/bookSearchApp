package com.example.bookSearchApp.data.entity

data class Book(
    val title: String,
    val link: String,
    val author: String,
    val discount: String?,
    val publisher: String,
    val isbn: String,
    val description: String,
    val image: String
)
