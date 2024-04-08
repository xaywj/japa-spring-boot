package com.learning.studying.Services;

import com.learning.studying.Models.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBookById(Long id);

    Book saveBook(Book book);

    Book updateBook(Book book, Long id);

    String deleteBook(Long id);
}