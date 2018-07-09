package com.abhi.spring.tdd.service;

import com.abhi.spring.tdd.entity.Book;

public interface BookService {

	public Book getBook(Long bookId);

	public Book createBook(Book book);

}
