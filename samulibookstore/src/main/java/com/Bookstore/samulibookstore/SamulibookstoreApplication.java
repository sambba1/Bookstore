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
			repository.save(new Book("Seppo Taalasmaa", "juupelis", 2010, "197434-2342", 345));
			repository.save(new Book("Ismo Laitela", "jogggo", 2017, "197434-2342", 56));
			repository.save(new Book("Suppo Laitela", "g", 2022, "197434-2342", 46));
			repository.save(new Book("Osteri Ossi", "jofhhhfo", 1989, "197434-2342", 868));
		};
		
	}

}
