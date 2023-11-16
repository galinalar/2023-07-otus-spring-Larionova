package spring10.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring10.dto.AuthorDto;
import spring10.service.AuthorService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthorApiController {
    private final AuthorService authorService;

    @GetMapping("/api/authors/")
    public List<AuthorDto> listBooks() {
        return authorService.getAll();
    }
}
