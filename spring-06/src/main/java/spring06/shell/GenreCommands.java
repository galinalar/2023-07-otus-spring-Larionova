package spring06.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import spring06.service.GenreService;

@RequiredArgsConstructor
@ShellComponent
public class GenreCommands {
    private final GenreService genreService;

    @ShellMethod(value = "get genres", key = {"genres", "g"})
    public String getAllGenres() {
        return genreService.getAll().toString();
    }
}
