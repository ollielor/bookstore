package fi.haagahelia.bookstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.bookstore.domain.Category;
import fi.haagahelia.bookstore.domain.CategoryRepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryJpaTest {
	
	@Autowired
	private CategoryRepository repository;
	
	@Test
	public void findByNameShouldReturnCategory() {
		List<Category> categories = repository.findByName("Children's books");
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getCategoryId()).isNotNull();
	}

	@Test
	public void createNewCategory() {
		Category category = new Category("Crime novels");
		repository.save(category);
		assertThat(category.getCategoryId()).isNotNull();
	}
	
	@Test
	public void deleteCategory() {
		List<Category> categories = repository.findByName("Children's books");
		Long id = categories.get(0).getCategoryId();
		repository.deleteById(id);
		List<Category> categoriesAfterDelete = repository.findByName("Children's books");
		assertThat(categoriesAfterDelete).hasSize(0);
	}
	
}
