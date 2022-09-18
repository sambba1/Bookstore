package com.Bookstore.samulibookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Bookstore.samulibookstore.domain.Book;
import com.Bookstore.samulibookstore.domain.BookRepository;
import com.Bookstore.samulibookstore.domain.Category;
import com.Bookstore.samulibookstore.domain.CategoryRepository;

@SpringBootApplication
public class SamulibookstoreApplication  {

	public static void main(String[] args) {
		SpringApplication.run(SamulibookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository) {
		
		return(args)->{
			
			crepository.save(new Category("-"));
			crepository.save(new Category("ismo kirjat"));
			crepository.save(new Category("tomaatti"));
			repository.save(new Book("Seppo Taalasmaa", "juupelis", 2010, "197434-2342", 345, crepository.findByName("-").get(0)));
			repository.save(new Book("Ismo Laitela", "jogggo", 2017, "197434-2342", 56, crepository.findByName("-").get(0)));
			repository.save(new Book("Suppo Laitela", "g", 2022, "197434-2342", 46, crepository.findByName("-").get(0)));
			repository.save(new Book("Osteri Ossi", "jofhhhfo", 1989, "197434-2342", 868, crepository.findByName("-").get(0)));
		};
		
	}

}
