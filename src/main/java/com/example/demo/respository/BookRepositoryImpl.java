package com.example.demo.respository;

import com.example.demo.domain.Book;
import com.example.demo.exceptions.NonExistingBookException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class BookRepositoryImpl implements BookRepository{

    private List<Book> bookList;

    public BookRepositoryImpl() {
        bookList = new ArrayList<>();
        bookList.add(new Book("01-001","The day after day"));
        bookList.add(new Book("02-001","I am superman"));
        bookList.add(new Book("02-003","Bird can fly"));
        bookList.add(new Book("03-001","The mountain is high"));

    }

    @Override
    public Book getBookByISBN(String ISBN) {
        Book book;
        book = bookList.stream().filter(h -> h.getISBN().equals(ISBN)).findFirst().get();
        if(null == book) throw new NonExistingBookException();
        return book;
    }

    @Override
    public Optional<Book> getBookByName(String bookName) {
        return bookList.stream().filter(h -> h.getBookName().equals(bookName)).findAny();
    }

    @Override
    public void savaBook(Book book) {
        Objects.requireNonNull(book);
        bookList.add(book);

    }
}
