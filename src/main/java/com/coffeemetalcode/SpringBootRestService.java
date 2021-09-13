package com.coffeemetalcode;

import com.coffeemetalcode.controllers.Book;
import com.coffeemetalcode.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringBootRestService implements CommandLineRunner {
	@Autowired
	BookRepository books;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestService.class, args);
	}

	@Override
	public void run(String[] args) {
		List<Book> bookArr = books.findAll();

		for(Book item : bookArr) {
			System.out.println(item.getTitle());
		}
	}
}
