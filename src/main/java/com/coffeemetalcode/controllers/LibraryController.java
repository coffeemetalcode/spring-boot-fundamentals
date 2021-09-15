package com.coffeemetalcode.controllers;

import com.coffeemetalcode.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class LibraryController {
    @Autowired
    BookRepository books;

    @PostMapping("/addBook")
    public ResponseEntity<AddResponse> addBook(@RequestBody Book book) {
        AddResponse resp = new AddResponse();
        HttpHeaders headers = new HttpHeaders();
        // String id = book.getAisle() + book.getIsbn();
        String id = UUID.randomUUID().toString();
        book.setId(id);
        headers.add("id", id);

        books.save(book);
        resp.setMessage("Book added!");
        resp.setId(id);

        return new ResponseEntity<AddResponse>(resp, headers, HttpStatus.CREATED);
    }
}
