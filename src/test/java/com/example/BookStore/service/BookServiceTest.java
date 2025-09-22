package com.example.BookStore.service;

import com.example.BookStore.model.Author;
import com.example.BookStore.model.Book;
import com.example.BookStore.model.Publisher;
import com.example.BookStore.repository.BookRepository;
import com.example.BookStore.service.implementation.BookServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.AssertionsKt.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImp bookService;

    private Book givenBook;
    private Book savedBook;

    @BeforeEach
    void setUp(){
        Author defaultAuthor = Author.builder().name("Gorge R R martine").build();
        Publisher defaultPublisher = Publisher.builder().name("Pearson").build();
      givenBook =   Book.builder().name("Book Name").authors(Set.of(defaultAuthor)).publisher(defaultPublisher).build();
      savedBook = Book.builder().id(1L).name("Book Name").authors(Set.of(defaultAuthor)).publisher(defaultPublisher).build();

    }
    @Test
    void whenCreateBook_thenReturnSavedBook(){
        when(bookRepository.save(any(Book.class))).thenReturn(savedBook);
        Book actualBook = bookService.uploadBook(givenBook);
        assertAll(
                () -> assertNotNull(actualBook),
                () -> assertEquals(savedBook.getId(), actualBook.getId()),
                () -> assertEquals(savedBook.getName(), actualBook.getName()),
                () -> assertEquals(savedBook.getAuthors(), actualBook.getAuthor()),
                ()-> assertEquals(savedBook.getPublisher(), actualBook.getPublisher())
        );
    }
}
