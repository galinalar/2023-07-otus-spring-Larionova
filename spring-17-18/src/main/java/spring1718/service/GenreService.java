package spring1718.service;

import spring1718.domain.Genre;
import spring1718.dto.GenreDto;

import java.util.List;

public interface GenreService {
    List<GenreDto> getAll();

    Genre geGenreById(Long id);

    Genre getGenreByName(String name);
}
