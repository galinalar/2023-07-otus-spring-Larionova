package spring10.service;

import spring10.domain.Genre;
import spring10.dto.GenreDto;

import java.util.List;

public interface GenreService {
    List<GenreDto> getAll();

    Genre geGenreById(Long id);

    Genre getGenreByName(String name);
}
