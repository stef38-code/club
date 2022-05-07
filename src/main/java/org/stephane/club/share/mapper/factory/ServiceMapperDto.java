package org.stephane.club.share.mapper.factory;

import java.util.List;

/**
 * Service Mapping
 * @param <T> Entities
 * @param <D> DTO
 */
public interface ServiceMapperDto<T, D> {
      T toEntity(D in);
      D toDto(T out);
     List<T> toEntities(List<D> in);
      List<D> toDtos(List<T> out);
}
