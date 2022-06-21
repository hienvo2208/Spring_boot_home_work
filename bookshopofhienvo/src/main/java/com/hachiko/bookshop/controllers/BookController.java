package com.hachiko.bookshop.controllers;


import com.hachiko.bookshop.dtos.BookDTO;
import com.hachiko.bookshop.entties.Book;
import com.hachiko.bookshop.facades.BookFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.validation.Valid;
import java.awt.*;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired private BookFacade bookFacade;
    @PostMapping("")
    public BookDTO addBook(@RequestBody @Valid BookDTO bookDTO){
        return bookFacade.addBook(bookDTO);
    }

    @GetMapping("")
    public List<BookDTO> getAll(){
        return (List<BookDTO>) bookFacade.findAll();
    }

    @GetMapping(params = "isbn")
    public BookDTO getBookByISBN(@RequestParam("isbn") String isbn){
        return bookFacade.findBookByISBN(isbn);
    }

    @GetMapping(params = "author")
    public List<BookDTO> getBooksByAuthor(@RequestParam("author") String author){
        return bookFacade.findBookByAuthor(author);
    }
    @GetMapping(params = "title")
    public List<BookDTO> getBookByTitle(@RequestParam("title") String title){
        return bookFacade.findBookByTitle(title);
    }


}
