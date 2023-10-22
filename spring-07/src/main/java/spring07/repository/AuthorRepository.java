package spring07.repository;

import org.springframework.data.repository.CrudRepository;
import spring07.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {}
