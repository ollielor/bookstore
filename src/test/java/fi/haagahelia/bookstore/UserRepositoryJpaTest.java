package fi.haagahelia.bookstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.bookstore.domain.User;
import fi.haagahelia.bookstore.domain.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryJpaTest {
	
	@Autowired
	private UserRepository repository;
	
	@Test
	public void findByUsernameShouldReturnUser() {
		User user = repository.findByUsername("admin");
		assertThat(user).isNotNull();
		assertThat(user.getId()).isNotNull();
	}

	@Test
	public void createNewUser() {
		User user = new User("olli", "$2a$10$LgoAmFp6cqE7e/Zwmzv2X.fAYeR5b7XH8NNmRvyp6ZqtcnjqGt0g2", "olli@olli.fi", "ADMIN");
		repository.save(user);
		assertThat(user.getId()).isNotNull();
	}
	
	@Test
	public void deleteUser() {
		User user = repository.findByUsername("user2");
		Long id = user.getId();
		repository.deleteById(id);
		assertThat(repository.findByUsername("user2")).isNull();
	}
	
}
