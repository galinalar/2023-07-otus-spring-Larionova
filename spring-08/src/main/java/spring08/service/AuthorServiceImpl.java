package spring08.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring08.domain.Author;
import spring08.dto.AuthorDto;
import spring08.mapper.AuthorMapper;
import spring08.repository.AuthorRepository;

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
