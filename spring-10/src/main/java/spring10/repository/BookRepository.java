package spring10.repository;

import org.springframework.data.repository.CrudRepository;
import spring10.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {}
