package com.example.bookSearchApp.domain.usecase

import com.example.bookSearchApp.data.source.BookApiService
import com.example.bookSearchApp.domain.model.BookModel
import com.example.bookSearchApp.domain.translator.BookTranslator.toBookModelList
import javax.inject.Inject

class BookRepository @Inject constructor(private val apiService: BookApiService) {
    private val CLIENT_ID = "3dQeMo3hLhiHXIdmW5_X"
    private val SECRET_KEY = "wIai6YPyUz"
    suspend fun searchBooks(query: String): List<BookModel> {
        val item = apiService.searchBooks(query,10,1, CLIENT_ID, SECRET_KEY).body()?.items
        return item?.toBookModelList() ?: listOf()
    }

}
/*
class UserUseCase @Inject constructor(
    private val reqresService: ReqresService
){
    suspend fun getUserList(page: Int): List<UserModel> {
        val data = reqresService.getUserList(page).body()?.data
        return data?.toUserModelList() ?: listOf()
    }
}*/