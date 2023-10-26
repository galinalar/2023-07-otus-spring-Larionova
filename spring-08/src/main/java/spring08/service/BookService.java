package spring08.service;

import spring08.domain.Book;
import spring08.dto.BookDto;

import java.util.List;

public interface BookService {

    List<BookDto> getAll();

    BookDto getBookById(Long id);

    Book getBookDomainById(Long id);

    void saveBook(Long id, String name, Long authorId, Long genreId);

    void updateBook(Long id, String name, Long authorId, Long genreId);

    void deleteBookById(Long id);
}
