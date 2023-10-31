package spring08.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring08.domain.Book;

public interface BookRepository extends MongoRepository<Book, Long> {}
