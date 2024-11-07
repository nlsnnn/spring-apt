package com.start.egor.library.controller;

import com.start.egor.library.dto.BookRentInfoDTO;
import com.start.egor.library.model.BookRentInfo;
import com.start.egor.library.service.BookRentInfoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rent/info")
@Tag(name = "Аренда книг",
        description = "Контроллер для работы с арендой/выдачей книг пользователям библиотеки")
public class BookRentController extends GenericController<BookRentInfo, BookRentInfoDTO> {
    public BookRentController(BookRentInfoService bookRentInfoService) {
        super(bookRentInfoService);
    }
}
