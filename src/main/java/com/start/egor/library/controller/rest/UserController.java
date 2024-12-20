package com.start.egor.library.controller.rest;

import com.start.egor.library.dto.UserDTO;
import com.start.egor.library.model.User;
import com.start.egor.library.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Tag(name = "Пользователи", description = "Контроллер для работы с пользователями библиотеки")
public class UserController extends GenericController<User, UserDTO> {
    public UserController(UserService userService) {
        super(userService);
    }
}
