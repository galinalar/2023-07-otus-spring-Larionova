package spring12.service;

import spring12.domain.Author;
import spring12.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    List<AuthorDto> getAll();

    Author geAuthorById(Long id);

    Author getAuthorByName(String name);
}
