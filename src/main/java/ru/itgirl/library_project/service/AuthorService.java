package ru.itgirl.library_project.service;

import ru.itgirl.library_project.dto.AuthorDto;
import ru.itgirl.library_project.dto.GenreDto;
import ru.itgirl.library_project.model.Genre;

public interface AuthorService {
    AuthorDto getAuthorById(Long id);
    GenreDto getGenreById(Long id);
}
