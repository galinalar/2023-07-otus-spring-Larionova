package spring14.repository;

import org.springframework.data.repository.CrudRepository;
import spring14.domain.h2.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Author findByName(String name);
}
