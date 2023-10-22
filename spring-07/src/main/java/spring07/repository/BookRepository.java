package spring07.repository;

import org.springframework.data.repository.CrudRepository;
import spring07.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {}
