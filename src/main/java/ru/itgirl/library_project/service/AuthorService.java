package ru.itgirl.library_project.service;

import ru.itgirl.library_project.dto.AuthorDto;
import ru.itgirl.library_project.dto.BookDto;

public interface AuthorService {
    AuthorDto getAuthorById(Long id);

    AuthorDto getAuthorByNameV1(String name);

    AuthorDto getAuthorByNameV2(String name);

    AuthorDto getAuthorByNameV3(String name);
}
