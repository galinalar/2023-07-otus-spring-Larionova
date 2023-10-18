package spring06.dao;

import spring06.domain.Genre;

import java.util.List;

public interface GenreDao {
    List<Genre> getAll();

    Genre getById(Long id);
}
