package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;

@CrossOrigin
@RestController
public class FirstController {

	@GetMapping("/welcome")
	public String welcomeMsg() {
		return "Welcome to Rest";
	}
	
	@GetMapping("/books")
	public List<Book> getBooks() {
		
		Book b1 = new Book(101,"Java",500.0);
		Book b2 = new Book(102,"spring",800.0);
		Book b3 = new Book(103,"hibernate",300.0);
		
		List<Book> bookList = new ArrayList<>();
		bookList.add(b1);
		bookList.add(b2);
		bookList.add(b3);
		
		return bookList;
	}
	
	@PostMapping("/addBook")
	public String addBook(@RequestBody Book book) {
		
		System.out.println(book);
		
		return "Books added Successfully";
	}
}
