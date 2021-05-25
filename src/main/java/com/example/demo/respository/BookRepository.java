package com.example.demo.respository;

import com.example.demo.domain.Book;

import java.util.Optional;

public interface BookRepository {

    Book getBookByISBN(String ISBN);

    Optional<Book> getBookByName(String bookName);

    void savaBook(Book book);


}
