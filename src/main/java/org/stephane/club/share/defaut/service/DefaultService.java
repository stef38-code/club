package org.stephane.club.share.defaut.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DefaultService<T, D, R extends JpaRepository> {
    List<D> findAll();
    D getById(String id);

    void update(D dto);

    void deleteById(String id);

    D save(D dto);
}
