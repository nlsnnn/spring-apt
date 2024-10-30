package com.start.egor.library.controller;

import com.start.egor.library.model.Author;
import com.start.egor.library.repository.AuthorRepository;
import com.start.egor.library.repository.GenericRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.webjars.NotFoundException;

@RestController
@RequestMapping("/authors")
@Tag(name = "Авторы", description = "Контроллер для работы с авторами из библиотеки")
public class AuthorController extends GenericController<Author>  {
    private final AuthorRepository authorRepository;


    protected AuthorController(GenericRepository<Author> genericRepository, AuthorRepository authorRepository) {
        super(genericRepository);
        this.authorRepository = authorRepository;
    }

//    @Operation(description = "Получить запись по Id", method = "getAuthorById")
//    @RequestMapping(value = "/getAuthorById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Author> getAuthorById(@RequestParam(value = "id") Long id){
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body(authorRepository.findById(id).orElseThrow(() -> new NotFoundException("Data are not found")));
//    }
}
