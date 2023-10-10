package spring06.dao;

import spring06.domain.Author;

import java.util.List;

public interface AuthorDao {

    List<Author> getAll();

    Author getById(Long id);
}
