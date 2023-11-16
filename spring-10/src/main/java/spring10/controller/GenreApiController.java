package spring10.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring10.dto.GenreDto;
import spring10.service.GenreService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GenreApiController {
    private final GenreService genreService;

    @GetMapping("/api/genres/")
    public List<GenreDto> listBooks() {
        return genreService.getAll();
    }
}
