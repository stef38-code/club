package org.stephane.club.share.mapper.factory;

import org.stephane.club.share.mapper.AdherentMapper;
import org.stephane.club.share.mapper.AdresseMapper;

public enum TypeServiceMapperDto {
    ADHERENT(AdherentMapper.class), ADRESSE(AdresseMapper.class);

    private Class<? extends ServiceMapperDto> mapperClass;

    TypeServiceMapperDto(Class<? extends ServiceMapperDto> mapperClass) {
        this.mapperClass = mapperClass;
    }

    public Class<? extends ServiceMapperDto> getMapperClass() {
        return this.mapperClass;
    }
}
