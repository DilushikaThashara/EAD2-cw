package com.example.demo.controllers;

import com.example.demo.dto.BookDTO;
import com.example.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping()
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping()
    public BookDTO addBook(@RequestBody BookDTO bookDTO) {
        return bookService.saveBook(bookDTO);
    }

    @PutMapping("/{id}")
    public BookDTO updateBook(@PathVariable int id, @RequestBody BookDTO bookDTO) {
        return bookService.updateBook(id, bookDTO);
    }

    @DeleteMapping("/delete-book/{id}")
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return "Book deleted successfully";
    }

    @GetMapping("/{id}")
    public BookDTO getBookById(@PathVariable int id) {
        return bookService.getBook(id);
    }
}

