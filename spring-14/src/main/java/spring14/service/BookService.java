package spring14.service;

import spring14.domain.h2.Book;
import spring14.dto.BookDto;

import java.util.List;

public interface BookService {

    List<BookDto> getAll();

    BookDto getBookById(Long id);

    Book getBookDomainById(Long id);

    void saveBook(String name, Long authorId, Long genreId);

    void updateBook(Long id, String name, Long authorId, Long genreId);

    void deleteBookById(Long id);
}
