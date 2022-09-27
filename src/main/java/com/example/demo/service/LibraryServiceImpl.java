package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Library;
import com.example.demo.repo.LibraryRepo;

@Service
public class LibraryServiceImpl implements LibraryService {

	@Autowired
	LibraryRepo libraryRepo;

	@Override
	public Library addLibrary(Library library) {
		Library library2 = libraryRepo.save(library);
		return library2;
	}

	@Override
	public Library updateLibrary(int id, Library library) {
		Optional<Library> findById = libraryRepo.findById(id);
		if (findById.isPresent()) {
			library.setId(findById.get().getId());
			Library save = libraryRepo.save(library);
			return save;
		}
		return null;
	}

	@Override
	public String deleteLibrary(int id) {
		Optional<Library> findById = libraryRepo.findById(id);
		if (findById.isPresent()) {
			libraryRepo.deleteById(id);
			return "Deleted...";
		}
		return null;
	}

	@Override
	public Library getById(int id) {
		Optional<Library> findById = libraryRepo.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Library> getAll() {
		List<Library> findAll = libraryRepo.findAll();
		return findAll;
	}

}
