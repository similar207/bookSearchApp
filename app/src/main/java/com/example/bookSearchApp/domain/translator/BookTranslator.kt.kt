package com.example.bookSearchApp.domain.translator

import com.example.bookSearchApp.data.entity.Book
import com.example.bookSearchApp.domain.model.BookModel

object BookTranslator{
    fun List<Book>.toBookModelList() = map {
        //BookModel(it.title, it.author, it.discount ,it.publisher , it.isbn, it.description, it.imageUrl)
        BookModel(it.title,it.link, it.author, it.discount, it.publisher, it.image)
    }
}
