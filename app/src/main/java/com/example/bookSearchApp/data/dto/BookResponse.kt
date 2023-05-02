package com.example.bookSearchApp.data.dto

import com.example.bookSearchApp.data.entity.Book

data class BookResponse(
    val lastBuildDate: String,
    val total: Int,
    val start: Int,
    val display: Int,
    val items: List<Book>
)