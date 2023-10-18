package spring06.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring06.dao.GenreDao;
import spring06.domain.Genre;
import spring06.dto.GenreDto;
import spring06.mapper.GenreMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreDao dao;

    private final GenreMapper mapper;

    @Override
    public List<GenreDto> getAll() {
        return dao.getAll().stream()
                .map(mapper::map).toList();
    }

    @Override
    public Genre geGenreById(Long id) {
        return dao.getById(id);
    }
}
