package com.example.BookStore

import com.example.BookStore.model.Author
import com.example.BookStore.model.Publisher

data class BookDto(
    var id: Long,
    var name: String,
    var author:  MutableSet<Author>,
    var publisher: Publisher
    )