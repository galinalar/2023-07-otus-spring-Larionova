package spring07.repository;

import org.springframework.data.repository.CrudRepository;
import spring07.domain.Author;

import java.util.List;


public interface AuthorRepository extends CrudRepository<Author, Long> {

    List<Author> findAll();
}
