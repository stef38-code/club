package org.stephane.club.share.mapper.factory;

import org.stephane.club.share.mapper.AdherentMapper;
import org.stephane.club.share.mapper.AdresseMapper;
import org.stephane.club.share.mapper.DepartementMapper;
import org.stephane.club.share.mapper.CommuneApiGouvMapper;

public enum TypeServiceMapperDto {
    ADHERENT(AdherentMapper.class), ADRESSE(AdresseMapper.class),DEPARTEMENT(DepartementMapper.class), GOUVAPICOMMUNE(CommuneApiGouvMapper.class);

    private Class<? extends ServiceMapperDto> mapperClass;

    TypeServiceMapperDto(Class<? extends ServiceMapperDto> mapperClass) {
        this.mapperClass = mapperClass;
    }

    public Class<? extends ServiceMapperDto> getMapperClass() {
        return this.mapperClass;
    }
}
