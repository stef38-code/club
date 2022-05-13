package org.stephane.club.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.stephane.club.config.aspect.TrackTime;
import org.stephane.club.dto.CommuneDto;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GouvCommunesServiceImpl implements GouvCommunesService {
    @Value("${enpoint.geo.api.gouv.communes.codePostal:https://geo.api.gouv.fr/communes?codePostal=}")
    private String urlCommunesParcodePostal;

    private final RestTemplate restTemplate;

    @Override
    @TrackTime
    public Collection<CommuneDto> rechercheCommunesParcodePostal(String codePosta) {
        CommuneDto[] forObject = restTemplate.getForObject(urlCommunesParcodePostal, CommuneDto[].class);
        /**
         ResponseEntity<List<User>> responseEntity =
         restTemplate.exchange(
         BASE_URL,
         HttpMethod.GET,
         null,
         new ParameterizedTypeReference<List<User>>() {}
         );
         List<User> userList = responseEntity.getBody();
         */
        return List.of(forObject);
    }
}
