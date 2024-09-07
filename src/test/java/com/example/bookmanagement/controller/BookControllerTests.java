package com.example.bookmanagement.controller;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.bookmanagement.model.Book;
import com.example.bookmanagement.service.BookService;

@WebMvcTest(BookController.class)
public class BookControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BookService bookService;
	
	@Test
	void testGetAllBooks() throws Exception {
		
		List<Book> books = Arrays.asList(
				new Book("Title1", "Author1", "ISBN1"),
				new Book("Title2", "Author2", "ISBN2")
			);
		
		when(bookService.getAllBooks()).thenReturn(books);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/api/books"))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("Title1"))
			.andExpect(MockMvcResultMatchers.jsonPath("$[1].title").value("Title2"));
	}
}
