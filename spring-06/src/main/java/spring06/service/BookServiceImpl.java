package spring06.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring06.dao.BookDao;
import spring06.domain.Book;
import spring06.dto.BookDto;
import spring06.dto.CommentDto;
import spring06.mapper.BookMapper;
import spring06.mapper.CommentMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;

    private final BookMapper mapper;

    private final CommentMapper commentMapper;

    @Override
    public List<BookDto> getAll() {
        return bookDao.getAll().stream()
                .map(mapper::map).toList();
    }

    @Override
    public BookDto getBookById(Long id) {
        return mapper.map(bookDao.getById(id));
    }

    @Override
    public Book getBookDomainById(Long id) {
        return bookDao.getById(id);
    }

    @Override
    @Transactional
    public void saveBook(Book book) {
        bookDao.insert(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        bookDao.update(book);
    }

    @Override
    @Transactional
    public void deleteBookById(Long id) {
        Book book = bookDao.getById(id);
        bookDao.deleteById(book);
    }

    @Override
    public List<CommentDto> getCommentByBook(Long id) {
        return bookDao.getCommentsByBook(id).stream()
                .map(commentMapper::map).toList();
    }
}
