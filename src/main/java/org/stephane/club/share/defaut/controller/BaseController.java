package org.stephane.club.share.defaut.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.stephane.club.share.defaut.service.BaseService;

import java.util.Collection;
import java.util.List;

/**
 * @param <T>  Entity
 * @param <ID> Key entity type
 * @Param <D> Dto
 */
@RequiredArgsConstructor
@Slf4j
public class BaseController<D, T, ID> {
    protected final BaseService<D, T, ID> service;
    @PostMapping
    public ResponseEntity<D> create(@RequestBody D dto) {
        D newDto = service.create(dto);
        return  new ResponseEntity<>(newDto, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<D> getById(@PathVariable ID id) {
        log.info(">> getById");
        D one = (D) service.get(id);
        return new ResponseEntity<>(one, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<D> update(@RequestBody D dto) {
        log.info(">> update");
        service.update(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable ID id) {
        log.info(">> update");
        service.deleteById(id);
    }
    @GetMapping
    public ResponseEntity<Collection<D>> getAll() {
        log.info(">> getAll");
        List<D> liste = service.findAll();
        return new ResponseEntity<>(liste, HttpStatus.OK);
    }
}
