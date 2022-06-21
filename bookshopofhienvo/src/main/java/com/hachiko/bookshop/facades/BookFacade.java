package com.hachiko.bookshop.facades;


import com.hachiko.bookshop.dtos.BookDTO;
import com.hachiko.bookshop.dtos.CustomerDTO;
import com.hachiko.bookshop.entties.Book;
import com.hachiko.bookshop.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.hachiko.bookshop.constants.ErrorCode.BOOK_ALREADY_EXISTS;
import static com.hachiko.bookshop.constants.ErrorCode.BOOK_NOT_FOUND;

@Service
public class BookFacade {
    @Autowired
    private BookService bookService;

    public BookDTO addBook(BookDTO bookDTO) {
        Optional<Book> bookOptional = bookService.findBookByISBN(bookDTO.getISBN());
        if (bookOptional.isPresent()) {
            bookDTO.setErrorMessage(BOOK_ALREADY_EXISTS.getMessage());
            bookDTO.setError(BOOK_ALREADY_EXISTS.getCode());
            return bookDTO;
        } else {
            Book book = Book
                    .builder()
                    .isbn(bookDTO.getISBN())
                    .title(bookDTO.getTitle())
                    .price(bookDTO.getPrice())
                    .author(bookDTO.getAuthor())
                    .pages(bookDTO.getPages())
                    .provider(bookDTO.getProvider())
                    .build();
            book = bookService.save(book);
            bookDTO.setId(book.getId());
        }
        return bookDTO;
    }

    public List<BookDTO> findAll() {
        return bookService.findAll()
                .stream()
                .map(BookDTO::fromBook)
                .collect(Collectors.toList());
    }

    public BookDTO findBookByISBN(String isbn) {
        Optional<Book> bookOptional = bookService.findBookByISBN(isbn);
        if (bookOptional.isPresent()) {
            return BookDTO.fromBook(bookOptional.get());
        }
        BookDTO bookDTO = new BookDTO();
        bookDTO.setErrorMessage(BOOK_NOT_FOUND.getMessage());
        bookDTO.setError(BOOK_NOT_FOUND.getCode());
        return bookDTO;
    }

    public List<BookDTO> findBookByAuthor(String author) {
        List<Book> books = bookService.findBookByAuthor(author);
        if(!books.isEmpty()){
            return books.stream()
                    .map(BookDTO::fromBook)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>(0);
    }

    public List<BookDTO> findBookByTitle(String title) {
        List<Book> books = bookService.findBookByTitle(title);
        if(!books.isEmpty()){
             List<BookDTO> results = books.stream()
                    .map(BookDTO::fromBook)
                    .collect(Collectors.toList());
             return results;
        }
        return new ArrayList<>(0);
    }


}
