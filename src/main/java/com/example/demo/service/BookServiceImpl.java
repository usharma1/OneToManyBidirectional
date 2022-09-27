package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.model.Library;
import com.example.demo.repo.BookRepo;
import com.example.demo.repo.LibraryRepo;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepo bookRepo;

	@Autowired
	LibraryRepo libraryRepo;

	@Override
	public Book addBook(Book book, int lid) {
		Optional<Library> optionalLibrary = libraryRepo.findById(lid);
		if (optionalLibrary.isPresent()) {
			book.setLibrary(optionalLibrary.get());

			Book save = bookRepo.save(book);
			return save;
		} else {
			return null;
		}
	}

//	@Override
//	public Book addBook(Book book) {
//		Optional<Library> optionalLibrary = libraryRepo.findById(book.getLibrary().getId());
//		if (optionalLibrary.isPresent()) {
//			book.setLibrary(optionalLibrary.get());
//
//			Book save = bookRepo.save(book);
//			return save;
//		} else {
//			return null;
//		}
//	}

	@Override
	public Book updateBook(int id, Book book) {

		Book book2 = null;
		Optional<Book> optionalBook = bookRepo.findById(id);

		if (optionalBook.isPresent()) {
			book2 = optionalBook.get();
			book2.setName(book.getName());
			return bookRepo.save(book2);
		} else {
			return null;
		}
	}

//	@Override
//	public Book updateBook(int id, Book book) {
//		Optional<Library> optionalLibrary = libraryRepo.findById(book.getLibrary().getId());
//		if (optionalLibrary.isPresent()) {
//
//			Optional<Book> optionalBook = bookRepo.findById(id);
//
//			if (optionalBook.isPresent()) {
//
//				book.setLibrary(optionalLibrary.get());
//				book.setId(optionalBook.get().getId());
//				bookRepo.save(book);
//			} else {
//				System.out.println("Sorry Book with Id is not present");
//			}
//		}
//		return null;
//	}

	@Override
	public String deleteBook(int id) {
		Optional<Book> optionalBook = bookRepo.findById(id);

		if (optionalBook.isPresent()) {
			bookRepo.delete(optionalBook.get());
			return "Deleted..";
		} else {
			return null;
		}
	}

	@Override
	public List<Book> getAll() {
		return bookRepo.findAll();
	}

	@Override
	public Book findById(int id) {
		Optional<Book> optionalBook = bookRepo.findById(id);

		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}

}
