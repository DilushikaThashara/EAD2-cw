package com.example.demo.services;

import com.example.demo.dto.BookDTO;
import com.example.demo.entities.Book;
import com.example.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public BookDTO saveBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setIsbn(bookDTO.getIsbn());
        bookRepository.save(book);
        return bookDTO;
    }

    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookDTO> bookList = new ArrayList<>();
        for (Book book : books) {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setId(book.getId());
            bookDTO.setTitle(book.getTitle());
            bookDTO.setAuthor(book.getAuthor());
            bookDTO.setIsbn(book.getIsbn());
            bookList.add(bookDTO);
        }
        return bookList;
    }

    public BookDTO updateBook(int id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id).orElse(new Book());
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setIsbn(bookDTO.getIsbn());
        bookRepository.save(book);
        return bookDTO;
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    public BookDTO getBook(int id) {
        Book book = bookRepository.findById(id).orElse(new Book());
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setIsbn(book.getIsbn());
        return bookDTO;
    }
}

