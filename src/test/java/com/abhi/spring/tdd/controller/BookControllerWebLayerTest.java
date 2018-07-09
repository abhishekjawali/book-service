package com.abhi.spring.tdd.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.abhi.spring.tdd.entity.Book;
import com.abhi.spring.tdd.service.BookServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerWebLayerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BookServiceImpl bookService;

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		Book sampleBook = createSampleBook();
		when(bookService.getBook(any(Long.class))).thenReturn(sampleBook);
		this.mockMvc.perform(get("/book/1")).andDo(print()).andExpect(status().isOk());
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
