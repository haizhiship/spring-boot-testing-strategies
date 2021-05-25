package com.example.demo.controller;


import com.example.demo.domain.Book;
import com.example.demo.respository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.management.OperatingSystemMXBean;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {


    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/{ISDN}")
    public Book getBookByISDN(@PathVariable String ISDN){
        return bookRepository.getBookByISBN(ISDN);
    }

    @GetMapping
    public Optional<Book> getBookByBookName(@RequestParam("name") String bookName){
        return bookRepository.getBookByName(bookName);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewBook(@RequestBody Book book){
        bookRepository.savaBook(book);
    }
}
