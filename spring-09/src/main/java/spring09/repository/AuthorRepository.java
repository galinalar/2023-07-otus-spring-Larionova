package spring09.repository;

import org.springframework.data.repository.CrudRepository;
import spring09.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Author getAuthorByName(String name);
}
