package spring07.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring07.domain.Author;
import spring07.dto.AuthorDto;
import spring07.mapper.AuthorMapper;
import spring07.repository.AuthorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;

    private final AuthorMapper mapper;

    @Override
    public List<AuthorDto> getAll() {
        return repository.findAll().stream()
                .map(mapper::map).toList();
    }

    @Override
    public Author geAuthorById(Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }
}
