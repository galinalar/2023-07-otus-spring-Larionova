package spring12.service;

import spring12.domain.Book;
import spring12.dto.BookDto;

import java.util.List;

public interface BookService {

    List<BookDto> getAll();

    BookDto getBookById(Long id);

    Book getBookDomainById(Long id);

    void saveBook(String name, String authorN, String genreN);

    void updateBook(Long id, String name, String authorN, String genreN);

    void deleteBookById(Long id);
}
