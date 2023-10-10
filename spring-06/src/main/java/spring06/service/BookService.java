package spring06.service;

import spring06.domain.Book;
import spring06.dto.BookDto;
import spring06.dto.CommentDto;

import java.util.List;

public interface BookService {

    List<BookDto> getAll();

    BookDto getBookById(Long id);

    Book getBookDomainById(Long id);

    void saveBook(Book book);

    void updateBook(Book book);

    void deleteBookById(Long id);

    List<CommentDto> getCommentByBook(Long id);
}
