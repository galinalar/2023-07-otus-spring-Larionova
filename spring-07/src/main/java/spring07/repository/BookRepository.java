package spring07.repository;

import org.springframework.data.repository.CrudRepository;
import spring07.domain.Book;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findAll();
}
