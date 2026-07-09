package com.example.graphql;


import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @QueryMapping
    public Book getBook(@Argument Long id) {
        return service.getBook(id);
    }

    @QueryMapping
    public List<Book> allBooks() {
        return service.getAllBooks();
    }

    @MutationMapping
    public Book createBook(@Argument String title, @Argument String author) {
        return service.createBook(title, author);
    }
}
