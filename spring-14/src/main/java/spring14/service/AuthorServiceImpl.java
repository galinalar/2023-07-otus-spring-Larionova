package spring14.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring14.domain.h2.Author;
import spring14.dto.AuthorDto;
import spring14.mapper.AuthorMapper;
import spring14.repository.AuthorRepository;

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
    public Author getAuthorById(Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }
}
