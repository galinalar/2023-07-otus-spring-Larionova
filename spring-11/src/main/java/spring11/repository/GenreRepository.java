package spring11.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import spring11.domain.Genre;

@Repository
public interface GenreRepository extends ReactiveCrudRepository<Genre, Long> {
    Mono<Genre> getGenreByName(String name);
}
