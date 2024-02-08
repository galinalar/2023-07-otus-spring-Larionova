package spring1718.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring1718.dto.BookDto;
import spring1718.service.AuthorService;
import spring1718.service.BookService;
import spring1718.service.GenreService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    private final AuthorService authorService;

    private final GenreService genreService;

    @GetMapping("/")
    public String listPage(Model model) throws InterruptedException {
        List<BookDto> books = bookService.getAll();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/edit")
    public String editPage(@RequestParam("id") long id, Model model) {
        BookDto book = bookService.getBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("authors", authorService.getAll());
        model.addAttribute("genres", genreService.getAll());
        return "edit";
    }

    @PostMapping("/edit")
    public String updateBook(BookDto book) {
        bookService.updateBook(book.getId(), book.getName(), book.getAuthor(), book.getGenre());
        return "redirect:/";
    }

    @GetMapping("/add")
    public String newBook(Model model) {
        model.addAttribute("authors", authorService.getAll());
        model.addAttribute("genres", genreService.getAll());
        model.addAttribute("book", new BookDto());
        return "new";
    }

    @PostMapping("/save")
    public String saveNewBook(BookDto book) {
        bookService.saveBook(book.getName(), book.getAuthor(), book.getGenre());
        return "redirect:/";
    }

    @PostMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return "redirect:/";
    }
}
