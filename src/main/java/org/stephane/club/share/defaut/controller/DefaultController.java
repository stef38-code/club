package org.stephane.club.share.defaut.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.stephane.club.share.defaut.service.DefaultService;

import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class DefaultController <D,S extends DefaultService>{
    public final S service;
    @GetMapping
    public ResponseEntity<Collection<D>> all() {
        log.info(">> all");
        List<D> liste = service.findAll();
        return new ResponseEntity<>(liste, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<D> one(@PathVariable String id) {
        log.info(">> one");
        D one = (D) service.getById(id);
        return new ResponseEntity<>(one, HttpStatus.OK);
    }
}
