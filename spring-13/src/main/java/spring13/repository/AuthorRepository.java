package spring13.repository;

import org.springframework.data.repository.CrudRepository;
import spring13.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Author getAuthorByName(String name);
}
