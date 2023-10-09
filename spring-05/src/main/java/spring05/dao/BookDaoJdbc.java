package spring05.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Component;
import spring05.domain.Book;
import spring05.dto.AuthorDto;
import spring05.dto.BookDto;
import spring05.dto.GenreDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class BookDaoJdbc implements BookDao {

    private final NamedParameterJdbcOperations namedParameterJdbcOperations;

    @Override
    public void insert(Book book) {
        namedParameterJdbcOperations.update(
                "insert into books (name, author_id, genre_id) values (:name, :author_id, :genre_id)",
                Map.of("name", book.getName(), "author_id", book.getAuthorId(),
                        "genre_id", book.getGenreId()));
    }

    @Override
    public BookDto getById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        return namedParameterJdbcOperations.queryForObject(
                "select b.id AS book_id, b.name AS book_name, a.id AS author_id, a.name AS author_name," +
                        " g.id AS genre_id, g.name AS genre_name " +
                        "from books b " +
                        "INNER JOIN AUTHORS a ON b.author_id = a.id " +
                        "INNER JOIN GENRES g ON b.genre_id = g.id " +
                        "WHERE b.id = :id", params, new BookRowMapper()
        );
    }

    @Override
    public List<BookDto> getAll() {
        return namedParameterJdbcOperations.getJdbcOperations().query(
                "select b.id AS book_id, b.name AS book_name, a.id AS author_id, a.name AS author_name," +
                " g.id AS genre_id, g.name AS genre_name " +
                        "from books b " +
                        "INNER JOIN AUTHORS a ON b.author_id = a.id " +
                        "INNER JOIN GENRES g ON b.genre_id = g.id ", new BookRowMapper());
    }

    @Override
    public void deleteById(long id) {
        Map<String, Object> params = Collections.singletonMap("id", id);
        namedParameterJdbcOperations.update(
                "delete from books where id = :id", params
        );
    }

    @Override
    public void update(Book book) {
        Map<String, Object> params = Map.of("name", book.getName(), "author", book.getAuthorId(),
                "genre", book.getGenreId(), "id", book.getId());
        namedParameterJdbcOperations.update(
                "update books set name = :name, author_id = :author, genre_id = :genre where id = :id", params
        );
    }

    private static class BookRowMapper implements RowMapper<BookDto> {

        @Override
        public BookDto mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            AuthorDto author = new AuthorDto(resultSet.getLong("author_id"),
                    resultSet.getString("author_name"));
            GenreDto genre = new GenreDto(resultSet.getLong("genre_id"),
                    resultSet.getString("genre_name"));
            return new BookDto(id, name, author, genre);
        }
    }
}
