package spring10.repository;

import org.springframework.data.repository.CrudRepository;
import spring10.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Author getAuthorByName(String name);
}
