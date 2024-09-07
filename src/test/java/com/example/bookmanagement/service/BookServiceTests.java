package com.example.bookmanagement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.bookmanagement.model.Book;
import com.example.bookmanagement.repository.BookRepository;

@SpringBootTest
public class BookServiceTests {

	@Autowired
	private BookService bookService;
	
	@MockBean
	private BookRepository bookRepository;
	
	@Test
	void testGetAllBooks() {
		when(bookRepository.findAll()).thenReturn(Arrays.asList(
				new Book("Title1", "Author1", "ISBN1"),
				new Book("Title2", "Author2", "ISBN2")
			));
		
		List<Book> books = bookService.getAllBooks();
		
		assertEquals(2, books.size());
		assertEquals("Title1", books.get(0).getTitle());
		assertEquals("Title2", books.get(1).getTitle());
	}
	
	@Test
	void testGetBookById() {
		Book book = new Book("Title", "Author", "ISBN");
		when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
		
		assertEquals("Title", bookService.getBookById(1L).get().getTitle());
	}
}
