package org.stephane.club.share.mapper.factory;

import org.mapstruct.factory.Mappers;

/**
 *
 * @param <T> Entity
 * @param <D> DTO
 */
public class ServiceMapperFactoryDtoImpl<T, D> extends ServiceMapperFactoryDto<T, D> {
    @Override
    public ServiceMapperDto<T, D> create(TypeServiceMapperDto type) {
        ServiceMapperDto mapper = Mappers.getMapper(type.getMapperClass());
        return mapper;
    }
}
