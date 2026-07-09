package com.example.graphql;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public Book getBook(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public Book createBook(String title, String author) {
        return repo.save(new Book(title, author));
    }
}

