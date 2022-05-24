package org.stephane.club.controllers.commune;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.stephane.club.dto.CommuneApiGouvDto;
import org.stephane.club.entities.CommuneApiGouvEntity;
import org.stephane.club.services.adresse.CommunesApiGouvService;
import org.stephane.club.share.defaut.controller.BaseController;
import org.stephane.club.share.defaut.service.BaseService;

public class CommuneBaseController extends BaseController<CommuneApiGouvDto, CommuneApiGouvEntity, String> {
    protected CommunesApiGouvService service;
    public CommuneBaseController(CommunesApiGouvService service) {
        super(service);
    }

}
