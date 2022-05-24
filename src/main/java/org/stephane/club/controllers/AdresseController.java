package org.stephane.club.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stephane.club.dto.AdresseDto;
import org.stephane.club.entities.AdresseEntity;
import org.stephane.club.services.adresse.AdresseService;
import org.stephane.club.share.defaut.controller.BaseController;

@RestController
@RequestMapping(
        value = "adresses",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})

@Slf4j
public class AdresseController extends BaseController<AdresseDto, AdresseEntity, String> {

    public AdresseController(final AdresseService service) {
        super(service);
    }
}
