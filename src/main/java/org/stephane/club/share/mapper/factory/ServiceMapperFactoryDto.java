package org.stephane.club.share.mapper.factory;

/**
 *
 * @param <T> Entity
 * @param <D> DTO
 */
public abstract class ServiceMapperFactoryDto<T, D> {
    public abstract ServiceMapperDto<T, D> create(TypeServiceMapperDto type);
}
