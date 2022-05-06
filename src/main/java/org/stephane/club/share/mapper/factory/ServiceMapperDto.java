package org.stephane.club.share.mapper.factory;

import java.util.List;

public abstract class ServiceMapperDto<I, D> {
    public abstract I toEntity(D in);
    public abstract D toDto(I out);
    public abstract List<I> toEntities(List<D> in);
    public abstract List<D> toDtos(List<I> out);
}
