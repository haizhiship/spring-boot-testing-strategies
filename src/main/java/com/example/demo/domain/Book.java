package com.example.demo.domain;

import java.util.Objects;

public final class Book {

    private String ISBN;
    private String bookName;

    public Book(String ISBN, String bookName) {
        this.ISBN = ISBN;
        this.bookName = bookName;
    }


    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return ISBN.equals(book.ISBN) &&
                bookName.equals(book.bookName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISBN, bookName);
    }
}
