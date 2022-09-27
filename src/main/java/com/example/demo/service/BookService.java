package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.Book;

@Component
public interface BookService {

	public Book addBook(Book book,int lid);
//	public Book addBook(Book book);

	public Book updateBook(int id, Book book);

	public String deleteBook(int id);

	public List<Book> getAll();

	public Book findById(int id);
}
