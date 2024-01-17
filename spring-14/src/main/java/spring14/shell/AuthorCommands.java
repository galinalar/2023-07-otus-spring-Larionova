package spring14.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import spring14.dto.AuthorDto;
import spring14.service.AuthorService;

import java.util.List;

@RequiredArgsConstructor
@ShellComponent
public class AuthorCommands {
    private final AuthorService authorService;

    @ShellMethod(value = "get authors", key = {"authors", "a"})
    public String getAllAuthors() {
        List<AuthorDto> authors = authorService.getAll();
        return authors.toString();
    }
}
