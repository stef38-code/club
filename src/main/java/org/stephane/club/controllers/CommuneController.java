package org.stephane.club.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stephane.club.dto.CommuneApiGouvDto;
import org.stephane.club.services.CommunesApiGouvService;

import java.util.Collection;

@RestController
@RequestMapping(
        value = "communes",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})

@Slf4j
@RequiredArgsConstructor
public class CommuneController {
    private final CommunesApiGouvService service;

    @GetMapping("/{id}")
    public ResponseEntity<Collection<CommuneApiGouvDto>> getByCodePostal(@PathVariable String id) {
        log.info(">> getByCodePostal {}",id);
        Collection<CommuneApiGouvDto> list =  service.rechercheCommunesParcodePostal(id);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
