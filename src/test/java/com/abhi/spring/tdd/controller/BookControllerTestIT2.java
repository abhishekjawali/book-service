package com.abhi.spring.tdd.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.abhi.spring.tdd.App;
import com.abhi.spring.tdd.entity.Book;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(

		classes = App.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-it.yml")
public class BookControllerTestIT2 {
	// This is IT
	@Autowired
	private MockMvc mockMvc;

	// @MockBean
	// private BookServiceImpl bookService;

	@Test
	public void getBookTest() throws Exception {
		Book book = createSampleBook();
		mockMvc.perform(MockMvcRequestBuilders.post("/book").content(asJsonString(book))
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON));

		this.mockMvc.perform(get("/book/2")).andDo(print()).andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private Book createSampleBook() {
		Book book = new Book();
		// book.setId(1L);
		book.setName("TDD");
		book.setAuthor("Author");
		book.setDescription("TDD");
		book.setPublisher("Publisher");

		return book;

	}
}
