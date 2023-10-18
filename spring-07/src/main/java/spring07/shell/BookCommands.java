package spring07.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import spring07.service.AuthorService;
import spring07.service.BookService;
import spring07.service.GenreService;

@RequiredArgsConstructor
@ShellComponent
public class BookCommands {
    private final BookService bookService;

    private final AuthorService authorService;

    private final GenreService genreService;

    @ShellMethod(value = "get books", key = {"books", "b"})
    public String getAllBooks() {
        return bookService.getAll().toString();
    }

    @ShellMethod(value = "get book by id", key = {"id"})
    public String getBookById(@ShellOption Long id) {
        return bookService.getBookById(id).toString();
    }

    @ShellMethod(value = "delete book by id", key = {"delete", "d"})
    public void deleteBookById(@ShellOption Long id) {
        bookService.deleteBookById(id);
    }

    @ShellMethod(value = "add book", key = {"add"})
    public void addBook(@ShellOption String name, @ShellOption(defaultValue = "1") Long authorId,
                        @ShellOption(defaultValue = "1") Long genreId) {
        bookService.saveBook(name, authorId, genreId);
    }

    @ShellMethod(value = "update book", key = {"update", "u"})
    public void updateBook(@ShellOption Long id, @ShellOption String name, @ShellOption Long authorId,
                           @ShellOption Long genreId) {
        bookService.updateBook(id, name, authorId, genreId);
    }
}
