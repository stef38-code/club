package org.stephane.club.share.defaut.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.stephane.club.share.exception.DataExistsException;
import org.stephane.club.share.exception.DataNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * CustomGenericService
 *
 * @param <D> DTO Type
 * @param <E> Entity Type
 * @param <KD> Key DTO Type
 * @param <KE> Key Entity key type
 */

public abstract class CustomGenericService<D, E, KD, KE> {

    protected JpaRepository<E, KE> repository;
    protected final String title;

    public CustomGenericService(JpaRepository<E, KE> repository, String title) {

        this.repository = repository;
        this.title = title;
    }
    @Transactional
    public D create(D d) {

        E e = toEntity(d);
        return toDto(repository.save(e));
    }
    @Transactional
    public D create(KD id, D d) throws DataExistsException {

       E e = toEntity(d);
        return toDto(repository.save(e));
    }

    @Transactional
    public void update(KD id, D d) {

        E e = toEntity(d);



        repository.save(e);
    }

    @Transactional(readOnly = true)
    public D select(KD id) {

       /* D allById = repository.findById(id);
        return toDto(allById);*/
        return null;
    }

    @Transactional
    public E get(KE id, boolean throwExceptionIfNotExists) {

        E e = repository.findById(id).orElse(null);

        if (throwExceptionIfNotExists && (e == null)) {
            throw new DataNotFoundException(title + "이(가) 존재하지 않습니다.");
        } else {
            return e;
        }
    }

    @Transactional
    public E get(KE id) {
        Optional<E> o = repository.findById(id);
        return o.orElseGet(() -> newEntity(id));
    }
    protected List<D> toDto(List<E> lst) {

        return lst.stream().map(this::toDto).collect(Collectors.toList());
    }

    protected abstract D toDto(E e);
    protected abstract E toEntity(D e);
    // protected abstract KD toKeyDto(KE e);
    protected abstract E newEntity();
    protected abstract E newEntity(KE e);
}
