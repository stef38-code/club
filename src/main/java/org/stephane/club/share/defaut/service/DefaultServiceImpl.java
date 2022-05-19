package org.stephane.club.share.defaut.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.stephane.club.config.aspect.TrackTime;
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
public class DefaultServiceImpl<T, D,R extends JpaRepository> extends CreateMapperDto<T, D> implements DefaultService<T, D> {
    @Getter
    private final JpaRepository repository;
    private TypeServiceMapperDto mapperType;

    public DefaultServiceImpl(final R repository, TypeServiceMapperDto mapperType) {
        this.repository = repository;
        this.mapperType = mapperType;
    }

    @TrackTime
    @Override
    public List<D> findAll() {
        List all = repository.findAll();
        log.info(">> findAll > {} elements", all.size());
        return getMapper(mapperType).toDtos(all);
    }

    @TrackTime
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

    @TrackTime
    @Override
    public void update(D dto) {
        log.info(">> update");
        T entityMpped = getMapper(mapperType).toEntity(dto);
        repository.save(entityMpped);
    }

    @TrackTime
    @Override
    public void deleteById(String id) {
        log.info(">> deleteById");
        D byId = getById(id);
        T entityMpped = getMapper(mapperType).toEntity(byId);
        repository.delete(entityMpped);
    }

    @TrackTime
    @Override
    public D save(D dto) {
        log.info(">> save");
        T entityMpped = getMapper(mapperType).toEntity(dto);
        T newEntity = (T) repository.save(entityMpped);

        return getMapper(mapperType).toDto(newEntity);
    }
}
