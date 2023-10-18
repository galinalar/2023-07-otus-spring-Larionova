package spring07.service;

import spring07.domain.Genre;
import spring07.dto.GenreDto;

import java.util.List;

public interface GenreService {
    List<GenreDto> getAll();

    Genre geGenreById(Long id);
}
