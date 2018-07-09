package com.abhi.spring.tdd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.spring.tdd.entity.Book;
import com.abhi.spring.tdd.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping(value = "/health")
	public String getHealth() {
		return "Server is running";
	}

	@GetMapping(value = "/book/{bookId}")
	public Book getBook(@PathVariable Long bookId) {
		return bookService.getBook(bookId);
	}

	@PostMapping(value = "/book")
	public Book addBook(@RequestBody Book book) {
		return bookService.createBook(book);
	}

}
