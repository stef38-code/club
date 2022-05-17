package org.stephane.club.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stephane.club.dto.AdherentDto;
import org.stephane.club.dto.GouvApiCommuneDto;
import org.stephane.club.services.AdherentService;
import org.stephane.club.services.GouvApiCommuneService;
import org.stephane.club.share.defaut.controller.DefaultController;

@RestController
@RequestMapping(
        value = "gouv/api/communes",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})

@Slf4j
public class GouvApiCommuneController extends DefaultController<GouvApiCommuneDto, GouvApiCommuneService> {
    public GouvApiCommuneController(final GouvApiCommuneService service) {
        super(service);
    }
}
