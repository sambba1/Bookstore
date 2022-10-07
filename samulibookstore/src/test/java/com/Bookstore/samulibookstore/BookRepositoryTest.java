package com.Bookstore.samulibookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.Bookstore.samulibookstore.domain.Book;
import com.Bookstore.samulibookstore.domain.BookRepository;
import com.Bookstore.samulibookstore.domain.CategoryRepository;



@ExtendWith(SpringExtension.class)
@DataJpaTest
class BookRepositoryTest {
	
	 @Autowired
	 private BookRepository brepository;
	 @Autowired
	 private CategoryRepository crepository;
	 
	 @Test
	 public void findByTitleShouldReturnIsbn() {
		 List<Book> books = brepository.findByTitle("juupelis");
		 assertThat(books).hasSize(1);
		 assertThat(books.get(0).getIsbn()).isEqualTo("197434-2342");
	 }
	 
	 @Test
	 public void createAndDeleteBook() {
		 Book book = new Book("dfg aaaaaaa", "ssss", 2010, "197434-2342", 345, crepository.findByName("-").get(0));
		 brepository.save(book);
		 assertThat(brepository.findById(book.getId())).isNotEmpty();
		 brepository.delete(book);
		 assertThat(brepository.findById(book.getId())).isEmpty();
		 
	 }
	 

	
}