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

import com.example.demo.model.Library;
import com.example.demo.service.LibraryService;

@RestController
@RequestMapping("lib")
public class LibraryController {

	@Autowired
	LibraryService libraryService;

	@PostMapping("/add")
	public Library create(@RequestBody Library library) {

		Library addLibrary = libraryService.addLibrary(library);
		if (addLibrary != null) {
			return addLibrary;
		} else {
			return null;
		}
	}

	@PutMapping("/update/{id}")
	public Library updateLibrary(@PathVariable int id, @RequestBody Library library) {
		return libraryService.updateLibrary(id, library);
	}

	@GetMapping("/get/{id}")
	public Library getById(@PathVariable int id) {
		Library byId = libraryService.getById(id);
		return byId;
	}

	@GetMapping("/getAll")
	public List<Library> getAll() {
		return libraryService.getAll();
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return libraryService.deleteLibrary(id);
	}
}