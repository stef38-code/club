package org.stephane.club.share.mapper.factory;

import org.stephane.basketback.share.mapper.personne.PersonneDtoMapper;
import org.stephane.basketback.share.mapper.sport.CategorieDtoMapper;

public enum TypeServiceMapperDto {
    PERSONNE(PersonneDtoMapper.class), CATEGORIE(CategorieDtoMapper.class);

    private Class<? extends ServiceMapperDto> mapperClass;

    TypeServiceMapperDto(Class<? extends ServiceMapperDto> mapperClass) {
        this.mapperClass = mapperClass;
    }

    public Class<? extends ServiceMapperDto> getMapperClass() {
        return this.mapperClass;
    }
}
