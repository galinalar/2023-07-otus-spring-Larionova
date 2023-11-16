package spring10.service;

import spring10.domain.Author;
import spring10.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    List<AuthorDto> getAll();

    Author geAuthorById(Long id);

    Author getAuthorByName(String name);
}
