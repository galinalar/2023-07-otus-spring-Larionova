package spring11.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.thymeleaf.spring6.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Mono;
import spring11.dto.BookDto;
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
        IReactiveDataDriverContextVariable variable =
                new ReactiveDataDriverContextVariable(bookService.getBookById(id).flux(), 1);
        Mono<BookDto> book = bookService.getBookById(id);
        model.addAttribute("books", variable);
        return "editBook";
    }

    @GetMapping("/add")
    public String newBook(Model model) {
        return "new";
    }
}
