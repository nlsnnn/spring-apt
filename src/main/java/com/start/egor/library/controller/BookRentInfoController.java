package com.start.egor.library.controller;

import com.start.egor.library.model.BookRentInfo;
import com.start.egor.library.repository.GenericRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book-rent")
@Tag(name = "Аренда", description = "Контроллер для работы с арендами книг")
public class BookRentInfoController extends GenericController<BookRentInfo> {
    public BookRentInfoController(GenericRepository<BookRentInfo> genericRepository) {
        super(genericRepository);
    }
}
