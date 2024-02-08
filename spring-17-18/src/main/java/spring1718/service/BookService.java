package spring1718.service;

import spring1718.domain.Book;
import spring1718.dto.BookDto;

import java.util.List;

public interface BookService {

    List<BookDto> getAll() throws InterruptedException;

    BookDto getBookById(Long id);

    Book getBookDomainById(Long id);

    void saveBook(String name, String authorN, String genreN);

    void updateBook(Long id, String name, String authorN, String genreN);

    void deleteBookById(Long id);
}
