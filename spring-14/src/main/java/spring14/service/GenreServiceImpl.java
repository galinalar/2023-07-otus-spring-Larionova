package spring14.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring14.domain.h2.Genre;
import spring14.dto.GenreDto;
import spring14.mapper.GenreMapper;
import spring14.repository.GenreRepository;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository repository;

    private final GenreMapper mapper;

    @Override
    public List<GenreDto> getAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(mapper::map).toList();
    }

    @Override
    public Genre getGenreById(Long id) {
        return  repository.findById(id).orElseThrow(RuntimeException::new);
    }
}
