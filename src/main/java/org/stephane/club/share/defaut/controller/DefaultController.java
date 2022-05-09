package org.stephane.club.share.defaut.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.stephane.club.share.defaut.service.DefaultService;

import java.util.Collection;
import java.util.List;

/**
 * Controller par défaut qui contient les mapping de base
 * create
 * getAll
 * getById
 * update
 * deleteById
 *
 * @param <D> Dto
 * @param <S> service
 */
@RequiredArgsConstructor
@Slf4j
public class DefaultController <D,S extends DefaultService>{
    public final S service;
    @PostMapping
    public ResponseEntity<D> create(@RequestBody D dto) {
        D newDto = (D) service.save(dto);
       return  new ResponseEntity<>(newDto, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<Collection<D>> getAll() {
        log.info(">> getAll");
        List<D> liste = service.findAll();
        return new ResponseEntity<>(liste, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<D> getById(@PathVariable String id) {
        log.info(">> getById");
        D one = (D) service.getById(id);
        return new ResponseEntity<>(one, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<D> update(@RequestBody D dto) {
        log.info(">> update");
        service.update(dto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id) {
        log.info(">> update");
        service.deleteById(id);
    }
}
