package com.syamsudin.demo.service;

import com.syamsudin.demo.entity.Author;
import com.syamsudin.demo.repository.AuthorRepository;
import com.syamsudin.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;


    @Autowired
    private BookRepository bookRepository;

    public void create(Author author) {
        authorRepository.save(author);
    }

//    public BookListResponse getBooks(BookListRequest request) {
//
//        BookSpecification bookSpecification = new BookSpecification(request);
//        Pageable pageable = PageRequest.of(request.getPage(), request.getSize(), Sort.by(Sort.Direction.fromString(request.getSortDirection().toString()), request.getSortBy()));
//        Page<Book> pages = bookRepository.findAll(bookSpecification, pageable);
//
//
//        return BookListResponse.builder()
//                .total(pages.getTotalElements())
//                .page(pages.getNumber())
//                .size(pages.getSize())
//                .bookList(pages.toList())
//                .build();
//    }
}
