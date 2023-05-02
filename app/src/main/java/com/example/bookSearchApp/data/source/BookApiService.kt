package com.example.bookSearchApp.data.source

import com.example.bookSearchApp.data.dto.BookResponse
//import com.example.recyclerviewwithmvvmhiltretrofit2.data.dto.UserListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface BookApiService {

    @GET("v1/search/book.json")
    suspend fun searchBooks(
        @Query("query") query: String,
        @Query("display") display: Int,
        @Query("start") start: Int,
        @Header("X-Naver-Client-Id") clientid: String,
        @Header("X-Naver-Client-Secret") secretKey: String
    ): Response<BookResponse>
}
/*
@Module
@InstallIn(ViewModelComponent::class)
abstract class MyModule{
    @Binds
    abstract fun bindRepository(remoteRepository: RemoteRepository) : BookApiService
}

 */
