package com.syamsudin.demo.service;

import com.syamsudin.demo.dto.BookListRequest;
import com.syamsudin.demo.entity.Book;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class BookSpecification implements Specification<Book> {

    private BookListRequest request;

    public BookSpecification(BookListRequest request) {
        this.request = request;
    }

    @Override
    public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        //create a new predicate list
        List<Predicate> predicates = new ArrayList<>();

        if (request.getTitle() != null) {
            predicates.add(
                    criteriaBuilder.like(
                            criteriaBuilder.lower(root.get("title")),
                            "%" + request.getTitle().toLowerCase() + "%")
            );
        }


        if (request.getAuthor() != null) {
            predicates.add(
                    criteriaBuilder.like(
                            criteriaBuilder.lower(root.get("author").get("name")),
                            "%" + request.getAuthor().toLowerCase() + "%")
            );
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
