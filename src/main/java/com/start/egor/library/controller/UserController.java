package com.start.egor.library.controller;

import com.start.egor.library.model.User;
import com.start.egor.library.repository.GenericRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Tag(name = "Пользователи", description = "Контроллер для работы с пользователями библиотеки")
public class UserController extends GenericController<User> {
    public UserController(GenericRepository<User> genericRepository) {
        super(genericRepository);
    }
}
