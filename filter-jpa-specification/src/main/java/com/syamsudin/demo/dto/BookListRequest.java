package com.syamsudin.demo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class BookListRequest implements Serializable {

    private Integer page = 1;
    private Integer size = 10;
    private String title;
    private String author;
    private String category;
    private List<String> tags;
    private SortDirection sortDirection = SortDirection.DESC;
    private String sortBy = "title";

}
