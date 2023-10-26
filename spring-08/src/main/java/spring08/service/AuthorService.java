package spring08.service;

import spring08.domain.Author;
import spring08.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    List<AuthorDto> getAll();

    Author getAuthorById(Long id);
}
