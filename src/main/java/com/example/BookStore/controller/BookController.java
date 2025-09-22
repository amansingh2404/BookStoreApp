package com.example.BookStore.controller;

import com.example.BookStore.model.Book;
import com.example.BookStore.service.BookService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.Logger;

@Controller
@RequestMapping("/book")
public class BookController {
    private static final Logger LOG =  LoggerFactory.getLogger(BookController.class);


    public final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("findByName")
public Book getBookById(@RequestParam String bookName){
        try {
            return bookService.getByName(bookName);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new RuntimeException("Error finding book. Please try again later");
        }

    }
}
