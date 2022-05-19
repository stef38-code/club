package org.stephane.club.share.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class HttpQueryImpl implements HttpQuery {
    private final RestTemplate restTemplate;

    @Override
    public <T> List getListByHttpQuery(String url, Map<String, Object> vars, ParameterizedTypeReference<List<T>> responseType) {
        ResponseEntity<List<T>> response =
                restTemplate.exchange(
                        url
                        ,
                        HttpMethod.GET,
                        null,
                        responseType,
                        vars
                );
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        }
        return Collections.EMPTY_LIST;
    }
}
