package com.example.bookmanagement.service;

import org.springframework.stereotype.Service;

import com.example.bookmanagement.model.Book;
import com.example.bookmanagement.repository.BookRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BookService {
	
	private final BookRepository bookRepository;
	
	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	public Optional<Book> getBookById(Long id) {
		return bookRepository.findById(id);
	}
	
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}
	
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
}
