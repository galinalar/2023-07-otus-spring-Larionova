package spring1718.repository;

import org.springframework.data.repository.CrudRepository;
import spring1718.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {}
