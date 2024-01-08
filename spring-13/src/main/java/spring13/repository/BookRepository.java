package spring13.repository;

import org.springframework.data.repository.CrudRepository;
import spring13.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {}
