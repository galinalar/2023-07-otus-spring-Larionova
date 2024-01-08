package spring12.repository;

import org.springframework.data.repository.CrudRepository;
import spring12.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {}
