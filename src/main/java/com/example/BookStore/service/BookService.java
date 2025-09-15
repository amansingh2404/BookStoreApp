package com.example.BookStore.service;

import com.example.BookStore.BookDto;
import org.springframework.http.ResponseEntity;

public interface BookService {

    ResponseEntity<?> uploadBook(BookDto bookDto);
}
