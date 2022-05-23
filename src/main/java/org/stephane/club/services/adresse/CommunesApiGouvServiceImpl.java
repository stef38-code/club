package org.stephane.club.services.adresse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.stephane.club.config.aspect.TrackTime;
import org.stephane.club.dto.CommuneApiGouvDto;
import org.stephane.club.entities.CommuneApiGouvEntity;
import org.stephane.club.repository.GouvApiCommuneRepository;
import org.stephane.club.share.defaut.service.DefaultServiceImpl;
import org.stephane.club.share.mapper.factory.TypeServiceMapperDto;
import org.stephane.club.share.rest.HttpQuery;

import java.util.*;

@Service
@Slf4j
public class CommunesApiGouvServiceImpl extends DefaultServiceImpl<CommuneApiGouvEntity, CommuneApiGouvDto, GouvApiCommuneRepository> implements CommunesApiGouvService {
    private HttpQuery httpQuery;
    @Value("${enpoint.geo.api.gouv.communes.codePostal:https://geo.api.gouv.fr/communes?codePostal={codePostal}}")
    private String urlCommunesParcodePostal;

    public CommunesApiGouvServiceImpl(GouvApiCommuneRepository repository, HttpQuery httpQuery) {
        super(repository, TypeServiceMapperDto.GOUVAPICOMMUNE);
    }

    @Override
    @TrackTime
    public Collection<CommuneApiGouvDto> rechercheCommunesParcodePostal(String codePostal) {
        log.info(">> rechercheCommunesParcodePostal");
        /*List<CommuneApiGouvEntity> byCodePostal = getRepository().getByCodePostal(codePostal);
        if(byCodePostal.isEmpty()){
            log.info("Elle est vide !!");
            List listCommuneWithGouvApi = getListCommuneWithGouvApi(codePostal);

        }
        return byCodePostal;*/
        return Collections.emptyList();
    }

    private List getListCommuneWithGouvApi(String codePostal) {
        Map<String, Object> vars = new HashMap<>();
        vars.put("codePostal", codePostal);
        ParameterizedTypeReference<List<CommuneApiGouvDto>> responseType = new ParameterizedTypeReference<>() {
        };

       /* return httpQueryImpl.getListByHttpQuery(urlCommunesParcodePostal, vars, responseType);*/
        return Collections.emptyList();
    }

}
