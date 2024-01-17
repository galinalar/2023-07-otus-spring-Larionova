package spring14.repository;

import org.springframework.data.repository.CrudRepository;
import spring14.domain.h2.Book;

public interface BookRepository extends CrudRepository<Book, Long> {}
