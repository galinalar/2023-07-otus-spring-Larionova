package spring05.dao;

import spring05.domain.Book;
import spring05.dto.BookDto;

import java.util.List;

public interface BookDao {
    void insert(Book book);

    BookDto getById(long id);

    List<BookDto> getAll();

    void deleteById(long id);

    void update(Book book);
}
