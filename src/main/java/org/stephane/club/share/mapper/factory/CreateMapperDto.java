package org.stephane.club.share.mapper.factory;

/**
 *
 * @param <T> Entity
 * @param <D> DTO
 */
public class CreateMapperDto<T, D> {
    public ServiceMapperDto<T, D> getMapper(TypeServiceMapperDto mapperType) {
        return getServiceMapperFactory().create(mapperType);
    }

    protected ServiceMapperFactoryDto<T, D> getServiceMapperFactory() {
        return new ServiceMapperFactoryDtoImpl<>();
    }
}
