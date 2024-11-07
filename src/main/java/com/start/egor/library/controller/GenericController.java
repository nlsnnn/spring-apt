package com.start.egor.library.controller;

import com.start.egor.library.dto.GenericDTO;
import com.start.egor.library.model.GenericModel;
import com.start.egor.library.repository.GenericRepository;
import com.start.egor.library.service.GenericService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@Slf4j
public abstract class GenericController <E extends GenericModel, D extends GenericDTO> {
    public final GenericService<E, D> service;

    protected GenericController(GenericService<E, D> service) {
        this.service = service;
    }

    @Operation(description = "Получить запись по ID", method = "getOne")
    @RequestMapping(value = "/getOne", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<D> getOne(@RequestParam(value = "id") Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getOne(id));
    }

    @Operation(description = "Получить все записи", method = "getAll")
    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<D>> getAll(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.listAll());
    }

    @Operation(description = "Создать запись", method = "create")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<D> create(@RequestBody D newEntity){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.create(newEntity));
    }

    @Operation(description = "Обновить запись", method = "update")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<D> update(@RequestBody D updateEntity, @RequestParam(value = "id") Long id){
        updateEntity.setId(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.update(updateEntity));
    }

    @Operation(description = "Удалить запись", method = "delete")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id){
        service.delete(id);
    }
}
