package spring11.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import spring11.domain.Author;
import spring11.dto.AuthorDto;
import spring11.mapper.AuthorMapper;
import spring11.repository.AuthorRepository;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;

    private final AuthorMapper mapper;

    @Override
    public Flux<AuthorDto> getAll() {
        return repository.findAll().map(mapper::map);
    }

    @Override
    public Mono<Author> getAuthorById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Author> getAuthorByName(String name) {
        return repository.getAuthorByName(name);
    }
}
