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
 * save()
 *
 * @param <T> entity
 * @param <D> Dto
 */
@Slf4j
@RequiredArgsConstructor
public class DefaultServiceImpl<T, D> extends CreateMapperDto<T, D> implements DefaultService<T, D> {
    private final JpaRepository repository;
    private TypeServiceMapperDto mapperType;

    public <R extends JpaRepository> DefaultServiceImpl(R repository, TypeServiceMapperDto mapperType) {
        this.repository = repository;
        this.mapperType = mapperType;
    }

    @Override
    public List<D> findAll() {
        List all = repository.findAll();
        log.info(">> findAll > {} elements", all.size());
        return getMapper(mapperType).toDtos(all);
    }

    @Override
    public D getById(String id) {
        log.info(">> getById");
        Optional byId = repository.findById(id);
        if (byId.isEmpty()) {
            log.warn(">> getById return null;//Todo A revoir");
            return null;//Todo A revoir
        }
        T d = (T) byId.get();
        return getMapper(mapperType).toDto(d);
    }

    @Override
    public void update(D dto) {
        log.info(">> update");
        T entityMpped = getMapper(mapperType).toEntity(dto);
        repository.save(entityMpped);
    }

    @Override
    public void deleteById(String id) {
        log.info(">> deleteById");
        D byId = getById(id);
        T entityMpped = getMapper(mapperType).toEntity(byId);
        repository.delete(entityMpped);
    }

    @Override
    public D save(D dto) {
        log.info(">> save");
        T entityMpped = getMapper(mapperType).toEntity(dto);
        T newEntity = (T) repository.save(entityMpped);

        return getMapper(mapperType).toDto(newEntity);
    }
}
