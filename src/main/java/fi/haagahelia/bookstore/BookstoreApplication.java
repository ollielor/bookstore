package fi.haagahelia.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
		}
	
		@Bean
		public CommandLineRunner demo(BookRepository repository) {
			return(args) -> {
				Book book1 = new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", 10.00);
				Book book2 = new Book("Animal Farm", "George Orwell", 1945, "2212343-5", 8.50);
				repository.save(book1);
				repository.save(book2);
			};
		}

}
