package org.stephane.club.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.stephane.club.controllers.commune.CommuneBaseController;
import org.stephane.club.dto.CommuneApiGouvDto;
import org.stephane.club.services.adresse.CommunesApiGouvService;

import java.util.List;

@RestController
@RequestMapping(
        value = "communes",
        produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})

@Slf4j
public class CommuneController extends CommuneBaseController {

    public CommuneController(final CommunesApiGouvService service) {
        super(service);
    }
    @GetMapping("/{codePostal}")
    public ResponseEntity<List<CommuneApiGouvDto>> getByCodePostal(@PathVariable String id) {
        List<CommuneApiGouvDto> communeApiGouvDtos = service.rechercheCommunesParcodePostal(id);
        return new ResponseEntity<>( communeApiGouvDtos,HttpStatus.OK);
    }
}
