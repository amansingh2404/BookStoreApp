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
            book.setAuthor(bookDto.getAuthor());
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
    public Book uploadBook(Book book) {

        try{
         //   Book book = getBookFormDto(bookDto, false);
            return bookRepository.save(book);

        }catch (Exception e){
          throw new RuntimeException("Unable to upload the book");
        }

    }
    @Override
    public Book getByName(String bookName){
        return bookRepository.findByName(bookName);
    }

}
