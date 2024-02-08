package spring1718.repository;

import org.springframework.data.repository.CrudRepository;
import spring1718.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Author getAuthorByName(String name);
}
