package spring07.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring07.domain.Genre;
import spring07.dto.GenreDto;
import spring07.mapper.GenreMapper;
import spring07.repository.GenreRepository;

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
    public Genre geGenreById(Long id) {
        return  repository.findById(id).orElseThrow(RuntimeException::new);
    }
}
