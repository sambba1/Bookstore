package com.Bookstore.samulibookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.Bookstore.samulibookstore.domain.Category;
import com.Bookstore.samulibookstore.domain.CategoryRepository;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class CategoryRepositoryTest {

	 @Autowired
	 private CategoryRepository crepository;
	 
	 @Test
	 public void findCategory() {
		 List<Category> c = crepository.findByName("-");
		 assertThat(c).hasSize(1);
		 assertThat(c.get(0).getName()).isEqualTo("-");
	 }
	 
	 @Test
	 public void createAndDeleteCategory() {
		 Category c = new Category("tomaatti");
		 crepository.save(c);
		 assertThat(crepository.findById(c.getCategoryid())).isNotEmpty();
		 crepository.delete(c);
		 assertThat(crepository.findById(c.getCategoryid())).isEmpty();
		 
	 }
	 
}
