package com.syamsudin.demo.controller;

import com.syamsudin.demo.dto.BookListRequest;
import com.syamsudin.demo.dto.BookListResponse;
import com.syamsudin.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public BookListResponse getBooks(BookListRequest request) {
        return bookService.getBooks(request);
    }
}
