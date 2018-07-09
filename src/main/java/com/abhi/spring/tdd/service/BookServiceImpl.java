package com.abhi.spring.tdd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.spring.tdd.entity.Book;
import com.abhi.spring.tdd.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepo;

	@Override
	public Book getBook(Long bookId) {
		return bookRepo.findOne(bookId);
	}

	@Override
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}

}
