package org.stephane.club.share.defaut.service;

import java.util.List;

public interface DefaultService<T, D> {
    List<D> findAll();

    D getById(String id);

    void update(D dto);

    void deleteById(String id);

    D save(D dto);
}
