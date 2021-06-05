package com.syamsudin.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
public class BookListRequest implements Serializable {

    private Integer page = 1;
    private Integer size = 10;
    private String title;
    private String author;
    private String category;
    private SortDirection sortDirection = SortDirection.DESC;
    private String sortBy = "title";

}
