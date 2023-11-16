package spring10.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring10.dto.BookDto;
import spring10.service.BookService;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/")
    public String listPage(Model model) {
        return "books";
    }

    @GetMapping("/edit/{id}")
    public String editPage(@PathVariable Long id, Model model) {
        BookDto book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "editBook";
    }

    @GetMapping("/add")
    public String newBook(Model model) {
        return "new";
    }
}
