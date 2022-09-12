package com.Bookstore.samulibookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Bookstore.samulibookstore.domain.Book;
import com.Bookstore.samulibookstore.domain.BookRepository;

@SpringBootApplication
public class SamulibookstoreApplication  {

	public static void main(String[] args) {
		SpringApplication.run(SamulibookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		
		return(args)->{

		};
		
	}

}
