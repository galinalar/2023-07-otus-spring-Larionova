package spring09.repository;

import org.springframework.data.repository.CrudRepository;
import spring09.domain.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {
    Genre getGenreByName(String name);
}
