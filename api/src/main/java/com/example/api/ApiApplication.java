package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.api.domain.Book;
import com.example.api.service.IService;

@SpringBootApplication
public class ApiApplication implements CommandLineRunner {

	@Autowired
	private IService<Book> service;
	
	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}

	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/greeting-javaconfig").allowedOrigins("http://localhost:3000");
			}
		};
	}

	@Override
	public void run(String... args) throws Exception {
		for(int i=1; i<=1000; i++) {
			Book book = new Book();
			book.setTitle("Spring Microservices in Action "+i);
			book.setAuthor("John Guest "+i);
			book.setCoverPhotoURL("https://images-na.ssl-images-amazon.com/images/I/417zLTa1uqL._SX397_BO1,204,203,200_.jpg");
			book.setIsbnNumber(1617293989L);
			book.setPrice(2776.00 + i);
			book.setLanguage("English");
			book.setGenre("Technology");
			service.saveOrUpdate(book);
		}
	}

}
