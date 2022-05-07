package org.stephane.club.share.defaut.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DefaultService<T, D, R extends JpaRepository> {
    List<D> findAll();
    D getById(String id);
}
