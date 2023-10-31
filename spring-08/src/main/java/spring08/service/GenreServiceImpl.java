package spring08.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring08.domain.Genre;
import spring08.dto.GenreDto;
import spring08.mapper.GenreMapper;
import spring08.repository.GenreRepository;

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
