package org.stephane.club.share.defaut.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.stephane.club.config.aspect.TrackTime;
import org.stephane.club.share.exception.DataNotFoundException;
import org.stephane.club.share.mapper.factory.CreateMapperDto;
import org.stephane.club.share.mapper.factory.TypeServiceMapperDto;

import java.util.List;
import java.util.Optional;

/**
 * @param <T>  Entity
 * @param <ID> Key entity type
 * @Param <D> Dto
 */
@RequiredArgsConstructor
@Slf4j
public abstract class BaseService<D, T, ID> extends CreateMapperDto<T, D> {
    protected final JpaRepository<T, ID> repository;
    protected final String title;

    @TrackTime
    @Transactional
    public D create(D d) {
        T entity = getMapper(getMapperType()).toEntity(d);
        return getMapper(getMapperType()).toDto(repository.save(entity));
    }
    @TrackTime
    @Transactional
    public void update(D d) {
        T entity = getMapper(getMapperType()).toEntity(d);
        repository.save(entity);
    }
    @TrackTime
    @Transactional(readOnly = true)
    public D get(ID id) {
        Optional<T> o = repository.findById(id);
        if (o.isEmpty()) {
            throw new DataNotFoundException(title.concat(" Data Not Found !"));
        }
        return getMapper(getMapperType()).toDto(o.get());
    }
    @TrackTime
    @Transactional
    public void deleteById(ID id) {
        log.info(">> deleteById");
        D byId = get(id);
        T entityMpped = getMapper(getMapperType()).toEntity(byId);
        repository.delete(entityMpped);
    }
    @TrackTime
    @Transactional(readOnly = true)
    public List<D> findAll() {
        List all = repository.findAll();
        log.info(">> findAll > {} elements", all.size());
        return getMapper(getMapperType()).toDtos(all);
    }

    protected abstract T newEntity(ID e);
    protected abstract TypeServiceMapperDto getMapperType();

}
