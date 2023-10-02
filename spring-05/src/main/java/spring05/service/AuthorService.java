package spring05.service;

import spring05.dto.AuthorDto;

import java.util.List;

public interface AuthorService {
    List<AuthorDto> getAll();
}
