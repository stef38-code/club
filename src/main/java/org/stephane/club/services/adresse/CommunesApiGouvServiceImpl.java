package org.stephane.club.services.adresse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.stephane.club.config.aspect.TrackTime;
import org.stephane.club.dto.CommuneApiGouvDto;
import org.stephane.club.entities.CommuneApiGouvEntity;
import org.stephane.club.repository.GouvApiCommuneRepository;
import org.stephane.club.share.mapper.factory.CreateMapperDto;
import org.stephane.club.share.mapper.factory.TypeServiceMapperDto;
import org.stephane.club.share.rest.HttpQuery;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommunesApiGouvServiceImpl extends CommunesApiGouvService {
    private final HttpQuery<CommuneApiGouvDto> httpQuery;
    @Value("${enpoint.geo.api.gouv.communes.codePostal:https://geo.api.gouv.fr/communes?codePostal={codePostal}}")
    private String urlCommunesParcodePostal;
    private final GouvApiCommuneRepository repository;


    @TrackTime
    public List<CommuneApiGouvDto> rechercheCommunesParcodePostal(String codePostal) {
        log.info(">> rechercheCommunesParcodePostal");
        List<CommuneApiGouvEntity> byCodePostal = repository.findByCodePostal(codePostal);
        if (byCodePostal.isEmpty()) {
            log.info("Elle est vide !!");
            List<CommuneApiGouvDto> listCommuneWithGouvApi = getListCommuneWithGouvApi(codePostal);
            List<CommuneApiGouvEntity> list = getMapper(getMapperType()).toEntities(listCommuneWithGouvApi);
            repository.saveAll(list);
            return listCommuneWithGouvApi;
        }
        return getMapper(getMapperType()).toDtos(byCodePostal);
    }
    private List<CommuneApiGouvDto> getListCommuneWithGouvApi(String codePostal) {
        Map<String, Object> vars = new HashMap<>();
        vars.put("codePostal", codePostal);
        ParameterizedTypeReference<List<CommuneApiGouvDto>> responseType = new ParameterizedTypeReference<>() {
        };

         return httpQuery.getListByHttpQuery(urlCommunesParcodePostal, vars, responseType);
    }


    protected TypeServiceMapperDto getMapperType() {
        return TypeServiceMapperDto.GOUVAPICOMMUNE;
    }
}
