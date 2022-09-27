package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.Library;

@Component
public interface LibraryService {

	public Library addLibrary(Library library);

	public Library updateLibrary(int id, Library library);
	
	public String deleteLibrary(int id);
	
	public Library getById(int id);
	
	public List<Library> getAll();
}
