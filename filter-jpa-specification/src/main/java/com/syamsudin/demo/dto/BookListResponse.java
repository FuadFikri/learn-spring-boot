package com.syamsudin.demo.dto;

import com.syamsudin.demo.entity.Book;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class BookListResponse implements Serializable {

    private Long total;
    private Integer page;
    private Integer size;
    private List<BookResponse> bookList;
}
