package com.syamsudin.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse implements Serializable {

    private Long id;

    private String title;

    private Integer year;

    private String language;

    private String category;

    private String authorName;
    private List<String> tags;
}
