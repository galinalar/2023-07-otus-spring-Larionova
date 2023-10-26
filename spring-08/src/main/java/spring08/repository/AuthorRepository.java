package spring08.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring08.domain.Author;

public interface AuthorRepository extends MongoRepository<Author, Long> {}
