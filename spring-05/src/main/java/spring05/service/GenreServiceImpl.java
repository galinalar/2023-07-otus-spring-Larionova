package spring05.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring05.dao.GenreDao;
import spring05.dto.GenreDto;
import spring05.mapper.GenreMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreDao dao;

    private final GenreMapper mapper;

    @Override
    @Transactional
    public List<GenreDto> getAll() {
        return dao.getAll().stream()
                .map(mapper::map).toList();
    }
}
