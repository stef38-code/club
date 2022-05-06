package org.stephane.club.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.stephane.club.dto.AdherentDto;
import org.stephane.club.services.AdherentService;
import org.stephane.club.services.DefaultService;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class DefaultController<T,S extends DefaultService<T>> {
    private final S service;

    @GetMapping
    public ResponseEntity<Collection<T>> lister() {
        log.info(">> lister");
        List<T> liste = service.getAll();
        return new ResponseEntity<>(liste, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public T one(@PathVariable String id) {
        log.info(">> one");
        T one = service.one(id);
        return one;
    }
}
