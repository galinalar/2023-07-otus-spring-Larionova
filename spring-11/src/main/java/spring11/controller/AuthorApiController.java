package spring11.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import spring11.dto.AuthorDto;
import spring11.service.AuthorService;

@RestController
@RequiredArgsConstructor
public class AuthorApiController {
    private final AuthorService authorService;

    @GetMapping("/api/authors/")
    public Flux<AuthorDto> listBooks() {
        return authorService.getAll();
    }
}
