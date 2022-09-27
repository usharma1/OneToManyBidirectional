package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("book")
public class BookController {

	@Autowired
	BookService bookService;

//	@PostMapping("/add")
//	public Book create(@RequestBody Book book) {
//
//		Book addBook = bookService.addBook(book);
//		if (addBook != null) {
//			return addBook;
//		} else {
//			return null;
//		}
//	}

	@PostMapping("/add/{lid}")
	public Book create(@PathVariable int lid,@RequestBody Book book) {

		Book addBook = bookService.addBook(book,lid);
		if (addBook != null) {
			return addBook;
		} else {
			return null;
		}
	}
	
	@PutMapping("/update/{id}")
	public Book updateBook(@PathVariable int id, @RequestBody Book book) {
		return bookService.updateBook(id, book);
	}

	@GetMapping("/get/{id}")
	public Book getById(@PathVariable int id) {
		Book byId = bookService.findById(id);
		return byId;
	}

	@GetMapping("/getAll")
	public List<Book> getAll() {
		return bookService.getAll();
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return bookService.deleteBook(id);
	}
}