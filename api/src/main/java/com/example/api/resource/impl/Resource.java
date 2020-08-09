package com.example.api.resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface Resource<T> {
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/search/{searchText}")
	ResponseEntity<Page<T>> findAll(Pageable pageable, @PathVariable String searchText);

	@GetMapping
	@CrossOrigin(origins = "http://localhost:3000")
	ResponseEntity<Page<T>> findAll(int pageNumber, int pageSize, String sortBy, String sortDir);
	
	@GetMapping("{id}")
	@CrossOrigin(origins = "http://localhost:3000")
	ResponseEntity<T> findById(@PathVariable Long id);
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@CrossOrigin(origins = "http://localhost:3000")
	ResponseEntity<T> save(@RequestBody T t);
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@CrossOrigin(origins = "http://localhost:3000")
	ResponseEntity<T> update(@RequestBody T t);
	
	@DeleteMapping("{id}")
	@CrossOrigin(origins = "http://localhost:3000")
	ResponseEntity<String> deleteById(@PathVariable Long id);
}
