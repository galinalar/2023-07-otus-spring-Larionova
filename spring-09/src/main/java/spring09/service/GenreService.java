package spring09.service;

import spring09.domain.Genre;
import spring09.dto.GenreDto;

import java.util.List;

public interface GenreService {
    List<GenreDto> getAll();

    Genre geGenreById(Long id);

    Genre getGenreByName(String name);
}
