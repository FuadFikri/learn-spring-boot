package com.syamsudin.demo.service.mapper;

import com.syamsudin.demo.dto.BookResponse;
import com.syamsudin.demo.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(target = "authorName", expression = "java( entity.getAuthor().getName() )")
    BookResponse toDto(Book entity);

    List<BookResponse> toDtos(List<Book> entity);


}
