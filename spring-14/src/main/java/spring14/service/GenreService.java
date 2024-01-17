package spring14.service;

import spring14.domain.h2.Genre;
import spring14.dto.GenreDto;

import java.util.List;

public interface GenreService {
    List<GenreDto> getAll();

    Genre getGenreById(Long id);
}
