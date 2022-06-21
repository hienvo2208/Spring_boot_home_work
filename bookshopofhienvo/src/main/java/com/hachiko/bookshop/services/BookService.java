package com.hachiko.bookshop.services;

import java.util.List;
import com.hachiko.bookshop.dtos.BookDTO;
import com.hachiko.bookshop.entties.Book;
import com.hachiko.bookshop.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> findBookByISBN(String isbn) {
        return bookRepository.findBookByIsbn(isbn);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public List<Book> findBookByAuthor(String author){
        return bookRepository.findBookByAuthor(author);
    }

    public List<Book> findBookByTitle(String title){
        return bookRepository.findBookByTitle(title);
    }
}
