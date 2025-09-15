package com.example.BookStore.service.implementation;

import com.example.BookStore.BookDto;
import com.example.BookStore.model.Book;
import com.example.BookStore.repository.BookRepository;
import com.example.BookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class BookServiceImp implements BookService {

    public final BookRepository bookRepository;

    @Autowired
    public BookServiceImp(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public Book getBookFormDto( BookDto bookDto, boolean isUpdate){
        if(isUpdate){
            Book book = bookRepository.findById( bookDto.getId()).orElse(null);
            assert book != null;
            book.setName(bookDto.getName());
            book.getAuthor(bookDto.getAuthor());
            book.setPublisher(bookDto.getPublisher());
            return book;

        }
        else{
            Book newBook = new Book();
            newBook.setName(bookDto.getName());
            newBook.setAuthor(bookDto.getAuthor());
            newBook.setPublisher(bookDto.getPublisher());
            return newBook;
        }
    }


    @Override
    public ResponseEntity<?> uploadBook(BookDto bookDto) {

        try{
            Book book = getBookFormDto(bookDto, false);
           Book savedBook =   bookRepository.save(book);
            URI  location= ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedBook.getId())
                    .toUri();
            return ResponseEntity.created(location).body(savedBook);
        }catch (Exception e){
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error Creating book" + e.getMessage());
        }

    }
}
