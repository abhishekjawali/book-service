package com.abhi.spring.tdd.controller;

import static org.hamcrest.CoreMatchers.containsString;
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

import com.abhi.spring.tdd.service.BookServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest
public class BookControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BookServiceImpl bookService;

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/health")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Server is running")));
		// Note: Here server is not started, hence actuator points are not available. if
		// server is started then response will be Server:UP
	}
}
