package fi.haagahelia.bookstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import fi.haagahelia.bookstore.domain.Category;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryJpaTest {
	
	@Autowired
	private BookRepository repository;
	
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = repository.findByTitle("A Farewell to Arms");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Ernest Hemingway");
	}

	@Test
	public void createNewBook() {
		Book book = new Book("The Little Prince", "Antoine de Saint-Exupery", 1943, "1111-111", 8.50, new Category("Children's books"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void deleteBook() {
		List<Book> books = repository.findByTitle("A Farewell to Arms");
		Long id = books.get(0).getId();
		repository.deleteById(id);
		List<Book> booksAfterDelete = repository.findByTitle("A Farewell to Arms");
		assertThat(booksAfterDelete).hasSize(0);
	}
	
}
