package spring13.service;

import spring13.domain.Genre;
import spring13.dto.GenreDto;

import java.util.List;

public interface GenreService {
    List<GenreDto> getAll();

    Genre geGenreById(Long id);

    Genre getGenreByName(String name);
}
