package org.stephane.club.share.rest;

import org.springframework.core.ParameterizedTypeReference;

import java.util.List;
import java.util.Map;

public interface HttpQuery {
    <T> List getListByHttpQuery(String url, Map<String, Object> vars, ParameterizedTypeReference<List<T>> responseType);
}
