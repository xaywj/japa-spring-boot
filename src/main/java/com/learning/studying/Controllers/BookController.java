package com.learning.studying.Controllers;

import com.learning.studying.Models.Book;
import com.learning.studying.Services.BookService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("{id}")
    public Book getBookById(@PathVariable long id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public Book saveBook(@RequestParam("file") @NotNull MultipartFile file, @RequestBody Book book){
        Book book1=new Book();
        book1.setFile(file.getOriginalFilename());
        book1.setTitle(book.getTitle());
        book1.setAuthor(book.getAuthor());
        book1.setIsbn(book.getIsbn());
        return bookService.saveBook(book1);
    }

    @PutMapping("{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable long id) {
        return bookService.updateBook(book, id);
    }

    @DeleteMapping("{id}")
    public String deleteBook(@PathVariable long id) {
        return bookService.deleteBook(id);
    }

    // Implement other CRUD endpoints

}
