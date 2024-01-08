package spring13.service;

import spring13.domain.Author;
import spring13.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    List<AuthorDto> getAll();

    Author geAuthorById(Long id);

    Author getAuthorByName(String name);
}
