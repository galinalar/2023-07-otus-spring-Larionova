package spring08.service;

import spring08.domain.Genre;
import spring08.dto.GenreDto;

import java.util.List;

public interface GenreService {
    List<GenreDto> getAll();

    Genre getGenreById(Long id);
}
