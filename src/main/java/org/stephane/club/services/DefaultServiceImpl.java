package org.stephane.club.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.stephane.club.entities.AdherentEntity;
import org.stephane.club.share.mapper.factory.CreateMapperDto;
import org.stephane.club.share.mapper.factory.TypeServiceMapperDto;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class DefaultServiceImpl<T, D, R extends JpaRepository> extends CreateMapperDto<T, D> implements AdherentService<T> {
    private final R repository;
    private TypeServiceMapperDto mapperType;
    public DefaultServiceImpl(R repository, TypeServiceMapperDto mapperType) {
        this.repository = repository;
        this.mapperType = mapperType;
    }

    @Override
    public List<T> getAll() {
        log.info(">> getAll");
        return getMapper(mapperType).toDtos(repository.findAll());
    }

    @Override
    public T one(String id) {
        log.info(">> one");
        return getMapper(mapperType).toDto(repository.findById(Optional.of(id)).orElse(null));
    }
}
