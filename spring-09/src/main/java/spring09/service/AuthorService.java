package spring09.service;

import spring09.domain.Author;
import spring09.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    List<AuthorDto> getAll();

    Author geAuthorById(Long id);

    Author getAuthorByName(String name);
}
