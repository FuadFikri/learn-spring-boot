package com.syamsudin.demo.service;

import com.syamsudin.demo.dto.BookListRequest;
import com.syamsudin.demo.dto.BookListResponse;
import com.syamsudin.demo.entity.Book;
import com.syamsudin.demo.repository.BookRepository;
import com.syamsudin.demo.service.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public BookListResponse getBooks(BookListRequest request) {

        BookSpecification bookSpecification = new BookSpecification(request);
        Integer page = request.getPage() - 1;
        Pageable pageable = PageRequest.of(page, request.getSize(), Sort.by(Sort.Direction.fromString(request.getSortDirection().toString()), request.getSortBy()));
        Page<Book> pages = bookRepository.findAll(bookSpecification, pageable);


        return BookListResponse.builder()
                .total(pages.getTotalElements())
                .page(pages.getNumber())
                .size(pages.getSize())
                .bookList(BookMapper.INSTANCE.toDtos(pages.toList()))
                .build();
    }



}
