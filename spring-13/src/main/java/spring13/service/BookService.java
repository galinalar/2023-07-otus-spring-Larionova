package spring13.service;

import spring13.domain.Book;
import spring13.dto.BookDto;

import java.util.List;

public interface BookService {

    List<BookDto> getAll();

    BookDto getBookById(Long id);

    Book getBookDomainById(Long id);

    void saveBook(String name, String authorN, String genreN);

    void updateBook(Long id, String name, String authorN, String genreN);

    void deleteBookById(Long id);
}
