package org.stephane.club.share.defaut.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * CustomGenericService - 서비스의 공통 기능 추상화(CRUD)
 * 재정의가 필요한 기능은 @Override해서 사용할것
 *
 * @author skyer9@gmail.com
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

    // 생성
    @Transactional
    public D create(D d) {

        E e = newEntity();
        updateFromDto(d, e);

        return toDto(repository.save(e));
    }

    // 체크 및 생성
    @Transactional
    public D create(KD id, D d) throws DataExistsException {

        KE ke = toKeyEntity(id);

        if (get(ke, false) != null) {
            throw new DataExistsException(title + "이(가) 이미 존재합니다.");
        }

        E e = newEntity(ke);
        updateFromDto(d, e);

        return toDto(repository.save(e));
    }

    // 수정
    @Transactional
    public void update(KD id, D d) {

        E e = get(toKeyEntity(id), true);
        updateFromDto(d, e);
        repository.save(e);
    }

    // DTO 조회
    @Transactional(readOnly = true)
    public D select(KD id) {

        return toDto(get(toKeyEntity(id), true));
    }

    // Entity 반환
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

    public abstract SearchResponseDto search(Map<String, String> params);

    protected List<D> toDto(List<E> lst) {

        return lst.stream().map(this::toDto).collect(Collectors.toList());
    }

    protected abstract D toDto(E e);
    protected abstract E toEntity(D e);
    // protected abstract KD toKeyDto(KE e);
    protected abstract KE toKeyEntity(KD e);
    protected abstract void updateFromDto(D d, E e);
    protected abstract E newEntity();
    protected abstract E newEntity(KE e);
}
