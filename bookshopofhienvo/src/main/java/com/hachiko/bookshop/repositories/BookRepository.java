package com.hachiko.bookshop.repositories;

import com.hachiko.bookshop.dtos.BookDTO;
import com.hachiko.bookshop.entties.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;
@Repository
public interface BookRepository  extends JpaRepository<Book, Long> {
    Optional<Book> findBookByIsbn(String isbn);

    List<Book> findAll();

    List<Book> findBookByAuthor(String author);

    List<Book> findBookByTitle(String title);
}
