package spring1718.service;

import spring1718.domain.Author;
import spring1718.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    List<AuthorDto> getAll();

    Author geAuthorById(Long id);

    Author getAuthorByName(String name);
}
