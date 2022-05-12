package org.stephane.club.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stephane.club.dto.AdresseDto;
import org.stephane.club.services.AdresseService;
import org.stephane.club.share.defaut.controller.DefaultController;

@RestController
@RequestMapping(
        value = "adresses",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})

@Slf4j
public class AdresseController extends DefaultController<AdresseDto, AdresseService> {
    public AdresseController(final AdresseService service) {
        super(service);
    }
}
