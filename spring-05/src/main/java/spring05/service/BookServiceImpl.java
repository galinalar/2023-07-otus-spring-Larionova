package spring05.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring05.dao.BookDao;
import spring05.domain.Book;
import spring05.dto.BookDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;

    @Override
    @Transactional
    public List<BookDto> getAll() {
        return bookDao.getAll();
    }

    @Override
    @Transactional
    public BookDto getBookById(Long id) {
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
        bookDao.deleteById(id);
    }
}
