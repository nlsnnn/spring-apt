package com.start.egor.library.controller.mvc;

import com.start.egor.library.dto.BookDTO;
import com.start.egor.library.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/books")
public class MVCBookController {
    private final BookService bookService;

    public MVCBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String getAll(Model model) {
        List<BookDTO> books = bookService.listAll();
        model.addAttribute("books", books);
        return "books/view-all-books";
    }
}
