package org.stephane.club.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stephane.club.dto.AdherentDto;
import org.stephane.club.services.adherent.AdherentService;
import org.stephane.club.share.defaut.controller.DefaultController;

@RestController
@RequestMapping(
        value = "adherents",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})

@Slf4j
public class AdherentController extends DefaultController<AdherentDto, AdherentService> {
    public AdherentController(final AdherentService service) {
        super(service);
    }
}
