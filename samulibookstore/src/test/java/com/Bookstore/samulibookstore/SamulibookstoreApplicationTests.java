package com.Bookstore.samulibookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.Bookstore.samulibookstore.web.BookController;
import com.Bookstore.samulibookstore.web.UserController;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class SamulibookstoreApplicationTests {

	@Autowired
	private BookController bcontroller;
	@Autowired
	private UserController ucontroller;

	
	@Test
	public void contextLoads() throws Exception {
		assertThat(bcontroller).isNotNull();
		assertThat(ucontroller).isNotNull();

	}

}

