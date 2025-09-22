package com.example.BookStore.service;

import com.example.BookStore.model.Book;
import org.springframework.http.ResponseEntity;

public interface BookService {

    Book uploadBook(Book bookDto);
    Book getByName(String bookName);
}
