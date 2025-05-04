package ru.itgirl.library_project.controller;

import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itgirl.library_project.dto.BookDto;
import ru.itgirl.library_project.service.BookService;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class BookControllerNew {

    private final BookService bookService;

    @GetMapping("/books")
    String getBooksView(Model model) {
        List<BookDto> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

}
