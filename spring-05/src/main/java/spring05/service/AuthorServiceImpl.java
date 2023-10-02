package spring05.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring05.dao.AuthorDao;
import spring05.dto.AuthorDto;
import spring05.mapper.AuthorMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao dao;

    private final AuthorMapper mapper;

    @Override
    @Transactional
    public List<AuthorDto> getAll() {
        return dao.getAll().stream()
                .map(mapper::map).toList();
    }
}
