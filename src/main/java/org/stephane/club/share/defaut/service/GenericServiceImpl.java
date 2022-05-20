package org.stephane.club.share.defaut.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.stephane.club.share.mapper.factory.TypeServiceMapperDto;

public class GenericServiceImpl<T, ID, R extends JpaRepository> extends GenericService<T, ID, R> {

    public GenericServiceImpl(R repository, TypeServiceMapperDto mapperType) {
        super(repository, mapperType);
    }

    @Override
    public ID getById(String id) {
        return null;
    }

    @Override
    public void update(ID dto) {

    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public ID save(ID dto) {
        return null;
    }
}
