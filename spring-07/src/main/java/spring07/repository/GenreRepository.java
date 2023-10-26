package spring07.repository;

import org.springframework.data.repository.CrudRepository;
import spring07.domain.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long> {
}
