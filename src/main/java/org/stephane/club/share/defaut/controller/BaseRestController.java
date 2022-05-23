package org.stephane.club.share.defaut.controller;

import org.springframework.http.ResponseEntity;
import org.stephane.club.share.defaut.service.CustomGenericService;

import java.util.Map;

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

public class BaseRestController<D, E, KD, KE> {

    protected final CustomGenericService<D, E, KD, KE> service;

    public BaseRestController(CustomGenericService<D, E, KD, KE> service) {
        this.service = service;
    }

    // PK 자동생성
    public ResponseEntity<?> create(D dto) {

        D created = service.create(dto);

        return ResponseEntity.ok(new ApiResponseWithData(ResponseCode.OK, created));
    }

    // PK 수동부여(PK 체크)
    public ResponseEntity<?> create(KD kd, D dto) {

        D created = service.create(kd, dto);

        return ResponseEntity.ok(new ApiResponseWithData(ResponseCode.OK, created));
    }

    public ResponseEntity<?> update(KD keyDto, D dto) {

        service.update(keyDto, dto);
        return ResponseEntity.ok(new ApiResponseMessage(ResponseCode.OK));
    }

    public ResponseEntity<?> select(KD keyDto) {

        D dto = service.select(keyDto);

        return ResponseEntity.ok(new ApiResponseWithData(ResponseCode.OK, dto));
    }

}
