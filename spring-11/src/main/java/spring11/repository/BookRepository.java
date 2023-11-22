package spring11.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import spring11.domain.Book;

@Repository
public interface BookRepository extends ReactiveCrudRepository<Book, Long> {}
