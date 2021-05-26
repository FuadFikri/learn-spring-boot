package com.syamsudin.demo.service;

import com.syamsudin.demo.dto.BookListRequest;
import com.syamsudin.demo.dto.BookListResponse;
import com.syamsudin.demo.dto.BookResponse;
import com.syamsudin.demo.entity.Book;
import com.syamsudin.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public BookListResponse getBooks(BookListRequest request) {

        BookSpecification bookSpecification = new BookSpecification(request);
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize(), Sort.by(Sort.Direction.fromString(request.getSortDirection().toString()), request.getSortBy()));
        Page<Book> pages = bookRepository.findAll(bookSpecification, pageable);


        return BookListResponse.builder()
                .total(pages.getTotalElements())
                .page(pages.getNumber())
                .size(pages.getSize())
                .bookList(this.toDtos(pages.toList()))
                .build();
    }

    private List<BookResponse> toDtos(List<Book> books) {
        List<BookResponse> responses = new ArrayList<>();
        for (Book book : books) {
            responses.add( this.toDto(book));
        }

        return responses;
    }

    private BookResponse toDto(Book book) {
        return BookResponse.builder().authorName(book.getAuthor().getName())
                .id(book.getId())
                .category(book.getCategory())
                .language(book.getLanguage())
                .title(book.getTitle())
                .year(book.getYear())
                .build();

    }
}
