package com.Bookstore.samulibookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.Bookstore.samulibookstore.domain.User;
import com.Bookstore.samulibookstore.domain.UserRepository;




@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UserRepositoryTest {
	 @Autowired
	 private UserRepository urepository;

	 
	 @Test
	 public void findUser() {
		 User user = urepository.findByUsername("user");
		 assertThat(user).isNotNull();
		 assertThat(user.getUsername()).isEqualTo("user");
	 }
	 
	 @Test
	 public void createAndDeleteUser() {
		 User user = new User("seppo", "asdasd", "USER");
		 urepository.save(user);
		 assertThat(urepository.findById(user.getId())).isNotEmpty();
		 urepository.delete(user);
		 assertThat(urepository.findById(user.getId())).isEmpty();
		 
	 }
}
