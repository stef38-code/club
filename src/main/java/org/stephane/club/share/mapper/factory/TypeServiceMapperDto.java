package org.stephane.club.share.mapper.factory;

import org.stephane.club.share.mapper.AdherentMapper;
import org.stephane.club.share.mapper.factory.ServiceMapperDto;

public enum TypeServiceMapperDto {
    ADHERENT(AdherentMapper.class);

    private Class<? extends ServiceMapperDto> mapperClass;

    TypeServiceMapperDto(Class<? extends ServiceMapperDto> mapperClass) {
        this.mapperClass = mapperClass;
    }

    public Class<? extends ServiceMapperDto> getMapperClass() {
        return this.mapperClass;
    }
}
