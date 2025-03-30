package ru.itgirl.library_project.service.impl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itgirl.library_project.dto.AuthorDto;
import ru.itgirl.library_project.dto.BookDto;
import ru.itgirl.library_project.dto.GenreDto;
import ru.itgirl.library_project.model.Author;
import ru.itgirl.library_project.model.Genre;
import ru.itgirl.library_project.repository.AuthorRepository;
import ru.itgirl.library_project.repository.GenreRepository;
import ru.itgirl.library_project.service.AuthorService;


import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private  final GenreRepository genreRepository;

    @Override
    public AuthorDto getAuthorById(Long id) {
        Author author = authorRepository.findById(id).orElseThrow();
        return convertToAuthorDto(author);
    }

    @Override
    public GenreDto getGenreById(Long id) {
         Genre genre = genreRepository.findById(id).orElseThrow();
        return convertToGenreDto(genre);
    }

    private AuthorDto convertToAuthorDto(Author author) {
        List<BookDto> bookDtoList = author.getBooks()
                .stream()
                .map(book -> BookDto.builder()
                        .genre(book.getGenre().getName())
                        .name(book.getName())
                        .id(book.getId())
                        .build()
                ).toList();
        return AuthorDto.builder()
                .books(bookDtoList)
                .id(author.getId())
                .name(author.getName())
                .surname(author.getSurname())
                .build();
    }

/*    private GenreDto convertToGenreDto(Genre genre) {
        List<BookDto> bookDtoList = genre.getBooks()
                .stream()
                .map(book -> BookDto.builder()
                        .genre(book.getGenre().getName())
                        .name(book.getName())
                        .id(book.getId())
                        .build()
                ).toList();

        return GenreDto.builder()
                .books(bookDtoList)
                .id(genre.getId())
                .name(genre.getName())
                .build();
    }*/

    private GenreDto convertToGenreDto(Genre genre) {
        List<BookDto> bookDtoList = genre.getBooks()
                .stream()
                .map(book -> {
                    List<AuthorDto> authorDtoList = book.getAuthors()
                            .stream()
                            .map(author -> AuthorDto.builder()
                                    .id(author.getId())
                                    .name(author.getName())
                                    .surname(author.getSurname())
                                    .build()
                            ).toList();

                    return BookDto.builder()
                            .id(book.getId())
                            .name(book.getName())
                            .genre(book.getGenre().getName())
                            .authors(authorDtoList)
                            .build();
                }).toList();

        return GenreDto.builder()
                .id(genre.getId())
                .name(genre.getName())
                .books(bookDtoList)
                .build();
    }

}