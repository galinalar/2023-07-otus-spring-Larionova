package spring07.repository;

import org.springframework.data.repository.CrudRepository;
import spring07.domain.Genre;

import java.util.List;

public interface GenreRepository extends CrudRepository<Genre, Long> {
    List<Genre> findAll();
}
