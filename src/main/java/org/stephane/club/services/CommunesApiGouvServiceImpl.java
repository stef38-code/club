package org.stephane.club.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.stephane.club.config.aspect.TrackTime;
import org.stephane.club.dto.CommuneApiGouvDto;

import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommunesApiGouvServiceImpl implements CommunesApiGouvService {
    private final RestTemplate restTemplate;
    @Value("${enpoint.geo.api.gouv.communes.codePostal:https://geo.api.gouv.fr/communes?codePostal={codePostal}}")
    private String urlCommunesParcodePostal;

    @Override
    @TrackTime
    public Collection<CommuneApiGouvDto> rechercheCommunesParcodePostal(String codePosta) {
        log.info(">> rechercheCommunesParcodePostal");
        Map<String, String> vars = new HashMap<>();
        vars.put("codePostal", codePosta);
        ParameterizedTypeReference<List<CommuneApiGouvDto>> responseType = new ParameterizedTypeReference<>() {
        };

        ResponseEntity<List<CommuneApiGouvDto>> response =
                restTemplate.exchange(
                        urlCommunesParcodePostal,
                        HttpMethod.GET,
                        null,
                        responseType,
                        vars
                );
        log.info(">> rechercheCommunesParcodePostal > status: {}", response.getStatusCode().toString());

        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        }
        return Collections.EMPTY_LIST;
    }
}
