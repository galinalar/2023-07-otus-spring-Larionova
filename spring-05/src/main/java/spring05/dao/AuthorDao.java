package spring05.dao;

import spring05.domain.Author;

import java.util.List;

public interface AuthorDao {

    List<Author> getAll();
}
