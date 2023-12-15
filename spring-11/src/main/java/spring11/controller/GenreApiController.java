package spring11.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import spring11.dto.GenreDto;
import spring11.service.GenreService;

@RestController
@RequiredArgsConstructor
public class GenreApiController {
    private final GenreService genreService;

    @GetMapping("/api/genres/")
    public Flux<GenreDto> listBooks() {
        return genreService.getAll();
    }
}
