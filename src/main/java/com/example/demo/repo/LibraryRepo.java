package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Library;

public interface LibraryRepo extends JpaRepository<Library, Integer> {

}
