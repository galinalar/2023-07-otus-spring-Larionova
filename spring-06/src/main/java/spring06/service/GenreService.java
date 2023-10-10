package spring06.service;

import spring06.domain.Genre;
import spring06.dto.GenreDto;

import java.util.List;

public interface GenreService {
    List<GenreDto> getAll();

    Genre geGenreById(Long id);
}
