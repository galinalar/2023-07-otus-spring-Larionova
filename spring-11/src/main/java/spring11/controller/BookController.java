package spring11.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import spring11.service.BookService;

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
        var attr = bookService.getBookById(id).flux();
        model.addAttribute("books", attr);
        return "editBook";
    }

    @GetMapping("/add")
    public String newBook(Model model) {
        return "new";
    }
}
