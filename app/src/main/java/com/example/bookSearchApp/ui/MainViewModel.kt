package com.example.bookSearchApp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bookSearchApp.domain.model.BookModel
import com.example.bookSearchApp.domain.usecase.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject internal constructor(
    private val bookRepository: BookRepository
): ViewModel() {
    private val _bookList = MutableStateFlow<List<BookModel>>(listOf())
    val bookList: StateFlow<List<BookModel>> = _bookList


    private val _text1 = MutableLiveData<String>()
    val text1 : MutableLiveData<String> = _text1

    init {
        readUserList()

    }

    fun onClickEvent(text: String){
        CoroutineScope(Dispatchers.IO).launch {
            _bookList.value = bookRepository.searchBooks(text)
            withContext(Dispatchers.Main) {
                println(_bookList.value)
            }

        }

    }

    fun readUserList() {

        viewModelScope.launch {
        }
    }

}