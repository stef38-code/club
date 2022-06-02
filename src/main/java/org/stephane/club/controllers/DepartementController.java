package org.stephane.club.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stephane.club.dto.DepartementEntityDto;
import org.stephane.club.entities.DepartementEntity;
import org.stephane.club.services.adresse.DepartementService;
import org.stephane.club.share.defaut.controller.BaseController;

@RestController
@RequestMapping(
        value = "gouv/api/departement",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})

@Slf4j
public class DepartementController extends BaseController<DepartementEntityDto, DepartementEntity, String> {
    public DepartementController(final DepartementService service) {
        super(service);
    }
}
