package com.learning.studying.Services;

import com.learning.studying.Models.Book;
import com.learning.studying.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book, Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book exstingBook = optionalBook.get();
            exstingBook.setAuthor(book.getAuthor());
            exstingBook.setIsbn(book.getIsbn());
            exstingBook.setTitle(book.getTitle());
            return bookRepository.save(exstingBook);
        } else {
            return null;
        }
    }

    @Override
    public String deleteBook(Long id) {
        Optional<Book> optionBook = bookRepository.findById(id);
        if (optionBook.isPresent()) {
            bookRepository.deleteById(id);
            return "delete success";
        } else {
            return "exitest delete ID:" + id;
        }
    }
}
