package spring05.service;

import spring05.domain.Book;
import spring05.dto.BookDto;

import java.util.List;

public interface BookService {

    List<BookDto> getAll();

    BookDto getBookById(Long id);

    void saveBook(Book book);

    void updateBook(Book book);

    void deleteBookById(Long id);
}
