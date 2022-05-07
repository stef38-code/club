package org.stephane.club.share.defaut.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.stephane.club.share.mapper.factory.CreateMapperDto;
import org.stephane.club.share.mapper.factory.TypeServiceMapperDto;

import java.util.List;
import java.util.Optional;

/**
 * Service par defaut qui va fournir les methodes de bases comme pour le JpaRepository
 * findAll()
 * getById()
 * saveAndFlush()
 * @param <T> entity
 * @param <D> Dto
 * @param <R> JpaRepository
 */
@Slf4j
@RequiredArgsConstructor
public class DefaultServiceImpl<T, D, R extends JpaRepository> extends CreateMapperDto<T, D> implements DefaultService<T, D, R > {
    private final R repository;
    private TypeServiceMapperDto mapperType;
    public DefaultServiceImpl(R repository, TypeServiceMapperDto mapperType) {
        this.repository = repository;
        this.mapperType = mapperType;
    }

    @Override
    public List<D> findAll() {
        log.info(">> findAll");
        return getMapper(mapperType).toDtos(repository.findAll());
    }

    @Override
    public D getById(String id) {
        log.info(">> one");
        Optional byId = repository.findById(id);
        if(byId.isEmpty()){
            log.warn(">> one return null;//Todo A revoir" );
            return null;//Todo A revoir
        }
        T d = (T) byId.get();
        return getMapper(mapperType).toDto(d);
    }
}
