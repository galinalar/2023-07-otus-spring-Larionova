package spring06.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring06.dao.AuthorDao;
import spring06.domain.Author;
import spring06.dto.AuthorDto;
import spring06.mapper.AuthorMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao dao;

    private final AuthorMapper mapper;

    @Override
    public List<AuthorDto> getAll() {
        return dao.getAll().stream()
                .map(mapper::map).toList();
    }

    @Override
    public Author geAuthorById(Long id) {
        return dao.getById(id);
    }
}
