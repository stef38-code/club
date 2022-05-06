package org.stephane.club.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.stephane.club.dto.AdherentDto;

import java.util.Collection;

public abstract class AbstractController<S> {

    @GetMapping
    public abstract ResponseEntity<Collection<AdherentDto>> lister();
}
