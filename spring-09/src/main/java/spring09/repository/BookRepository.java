package spring09.repository;

import org.springframework.data.repository.CrudRepository;
import spring09.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {}
