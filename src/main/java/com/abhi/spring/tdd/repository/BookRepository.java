package com.abhi.spring.tdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.spring.tdd.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
