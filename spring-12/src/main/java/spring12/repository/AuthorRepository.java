package spring12.repository;

import org.springframework.data.repository.CrudRepository;
import spring12.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Author getAuthorByName(String name);
}
