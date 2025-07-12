package com.vaishnavi.spring.boot.graphql.controller;

import com.vaishnavi.spring.boot.graphql.model.Author;
import com.vaishnavi.spring.boot.graphql.model.Book;
import com.vaishnavi.spring.boot.graphql.service.AuthorService;
import com.vaishnavi.spring.boot.graphql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @QueryMapping
    public Book bookById(@Argument int id) {
        return bookService.getById(id);
    }

    @SchemaMapping
    public Author author(Book book) {
        return authorService.getById(book.authorId());
    }

    @MutationMapping
    public Book addBook(@Argument Book book) {
        return bookService.addBook(book);
    }
}
