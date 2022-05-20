package org.stephane.club.share.defaut.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.stephane.club.share.mapper.factory.CreateMapperDto;
import org.stephane.club.share.mapper.factory.TypeServiceMapperDto;

import java.util.List;

/**
 *
 * @param <T>
 * @param <I>
 * @param <D>
 */
@RequiredArgsConstructor
public abstract class GenericService<T, D,R extends JpaRepository> extends CreateMapperDto<T,D> {

    protected final R repository;
    protected final TypeServiceMapperDto mapperType;

    public List<D> findAll(){
        List all = repository.findAll();
        return getMapper(mapperType).toDtos(all);
    }

    public abstract D getById(String id);

    public abstract void update(D dto);

    public abstract void deleteById(String id);

    public abstract D save(D dto);

}
