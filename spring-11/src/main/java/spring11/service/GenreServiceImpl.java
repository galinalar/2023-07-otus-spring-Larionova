package spring11.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import spring11.domain.Genre;
import spring11.dto.GenreDto;
import spring11.mapper.GenreMapper;
import spring11.repository.GenreRepository;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository repository;

    private final GenreMapper mapper;

    @Override
    public Flux<GenreDto> getAll() {
        return repository.findAll().map(mapper::map);
    }

    @Override
    public Mono<Genre> getGenreById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Genre> getGenreByName(String name) {
        return repository.getGenreByName(name);
    }
}
