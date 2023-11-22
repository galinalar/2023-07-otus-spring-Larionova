package spring11.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import spring11.domain.Genre;
import spring11.dto.GenreDto;

public interface GenreService {
    Flux<GenreDto> getAll();

    Mono<Genre> getGenreById(Long id);

    Mono<Genre> getGenreByName(String name);
}
