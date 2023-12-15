package spring11.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import spring11.domain.Author;
import spring11.dto.AuthorDto;

public interface AuthorService {
    Flux<AuthorDto> getAll();

    Mono<Author> getAuthorById(Long id);

    Mono<Author> getAuthorByName(String name);
}
