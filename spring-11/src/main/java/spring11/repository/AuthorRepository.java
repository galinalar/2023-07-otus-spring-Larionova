package spring11.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;
import spring11.domain.Author;

@Repository
public interface AuthorRepository extends ReactiveCrudRepository<Author, Long> {
    Mono<Author> getAuthorByName(String name);
}
