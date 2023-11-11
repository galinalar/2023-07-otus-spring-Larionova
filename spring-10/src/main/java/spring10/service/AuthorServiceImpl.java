package spring10.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring10.domain.Author;
import spring10.dto.AuthorDto;
import spring10.mapper.AuthorMapper;
import spring10.repository.AuthorRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;

    private final AuthorMapper mapper;

    @Override
    public List<AuthorDto> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(mapper::map).toList();
    }

    @Override
    public Author geAuthorById(Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Author getAuthorByName(String name) {
        return repository.getAuthorByName(name);
    }
}
