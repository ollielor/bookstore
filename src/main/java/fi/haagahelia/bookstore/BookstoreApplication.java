package fi.haagahelia.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookstore.domain.Book;
import fi.haagahelia.bookstore.domain.BookRepository;
import fi.haagahelia.bookstore.domain.Category;
import fi.haagahelia.bookstore.domain.CategoryRepository;
import fi.haagahelia.bookstore.domain.User;
import fi.haagahelia.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
		}
	
		@Bean
		public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
			return(args) -> {
				Category category1 = new Category("Novels");
				Category category2 = new Category("Children's books");
				crepository.save(category1);
				crepository.save(category2);
				
				Book book1 = new Book("A Farewell to Arms", "Ernest Hemingway", 1929, "1232323-21", 10.00, category1);
				Book book2 = new Book("Animal Farm", "George Orwell", 1945, "2212343-5", 8.50, category1);
				repository.save(book1);
				repository.save(book2);
				
				User user1 = new User("user1", "$2a$10$WIGJD4RRdklqp7g7nrTsguPuZo4miWy.MvrOXpvBz6HBEBR.2.yc.", "user1@user.com", "USER");
				User user2 = new User("user2", "$2a$10$H/sO5nJlaoQfVmm2Y7DN1uZzjGe5UK6F02IH5JrYp6WZJmNoZNR52", "user2@user.com", "USER");
				User admin = new User("admin", "$2a$10$HQJWdbJzfwiQ9Wgn51SJIuerkNhAN4SqrqtLwybcMa.sVtHfje8JO", "admin@admin.com", "ADMIN");
				urepository.save(user1);
				urepository.save(user2);
				urepository.save(admin);
				
			};
		}

}
