package com.abhi.spring.tdd.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.abhi.spring.tdd.entity.Book;
import com.abhi.spring.tdd.repository.BookRepository;

public class BookServiceTest {

	@InjectMocks
	private BookServiceImpl bookService;

	@Mock
	private BookRepository bookRepo;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetBook() {

		Book book = createSampleBook();
		when(bookRepo.findOne(1L)).thenReturn(book);

		Book bookRes = bookService.getBook(1L);
		verify(bookRepo).findOne(1L);
		assertThat(bookRes.getId(), is(1L));
	}

	@Test
	public void testCreateBook() {
		Book book = createSampleBook();
		when(bookRepo.save(book)).thenReturn(book);

		Book bookRes = bookService.createBook(book);
		verify(bookRepo).save(book);
		assertThat(bookRes.getId(), is(1L));
	}

	private Book createSampleBook() {
		Book book = new Book();
		book.setId(1L);
		book.setName("TDD");
		book.setAuthor("Author");
		book.setDescription("TDD");
		book.setPublisher("Publisher");

		return book;

	}
}
