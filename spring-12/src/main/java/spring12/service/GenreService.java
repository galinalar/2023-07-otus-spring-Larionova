package spring12.service;

import spring12.domain.Genre;
import spring12.dto.GenreDto;

import java.util.List;

public interface GenreService {
    List<GenreDto> getAll();

    Genre geGenreById(Long id);

    Genre getGenreByName(String name);
}
