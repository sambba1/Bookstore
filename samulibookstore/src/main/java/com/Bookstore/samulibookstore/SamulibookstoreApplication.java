package com.Bookstore.samulibookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Bookstore.samulibookstore.domain.Book;
import com.Bookstore.samulibookstore.domain.BookRepository;
import com.Bookstore.samulibookstore.domain.Category;
import com.Bookstore.samulibookstore.domain.CategoryRepository;
import com.Bookstore.samulibookstore.domain.User;
import com.Bookstore.samulibookstore.domain.UserRepository;

@SpringBootApplication
public class SamulibookstoreApplication  {

	public static void main(String[] args) {
		SpringApplication.run(SamulibookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		
		return(args)->{
			urepository.save(new User("user", "$2y$10$iyEr.tfpe9q2NrY0B9ayAeVsd4ljb5VHP8y/ioV/rFXrz2fv624yG", "USER"));
			urepository.save(new User("admin", "$2y$10$6P79CpftG0MpMstXlAgieuIZA3fRCD89iXHc8L6zTAcTLPyxjDAse", "ADMIN"));
			
			crepository.save(new Category("-"));
			crepository.save(new Category("ismo kirjat"));
			crepository.save(new Category("tomaatti"));
			
			brepository.save(new Book("Seppo Taalasmaa", "juupeli", 2010, "197434-2342", 345, crepository.findByName("-").get(0)));
			//brepository.save(new Book("Ismo Laitela", "jogggo", 2017, "197434-2342", 56, crepository.findByName("-").get(0)));
			//brepository.save(new Book("Suppo Laitela", "g", 2022, "197434-2342", 46, crepository.findByName("-").get(0)));
			//brepository.save(new Book("Osteri Ossi", "jofhhhfo", 1989, "197434-2342", 868, crepository.findByName("-").get(0)));
		};
		
	}

}
