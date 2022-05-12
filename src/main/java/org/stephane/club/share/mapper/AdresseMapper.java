package org.stephane.club.share.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.stephane.club.dto.AdresseDto;
import org.stephane.club.entities.AdresseEntity;
import org.stephane.club.fields.CodePostal;
import org.stephane.club.share.mapper.factory.ServiceMapperDto;

@Mapper
public abstract class AdresseMapper implements ServiceMapperDto<AdresseEntity, AdresseDto> {
    @Mapping(target = "codePostal", source = "codePostal", qualifiedByName = "ToCodePostalString")
    public abstract AdresseEntity toEntity(AdresseDto in) ;

    @Mapping(target = "codePostal", source = "codePostal", qualifiedByName = "ToCodePostalObject")
    public abstract AdresseDto toDto(AdresseEntity entity);

    @Named("ToCodePostalObject")
    public CodePostal toCodePostalObject(String value) {
        return new CodePostal(value);
    }
    @Named("ToCodePostalString")
    public String toCodePostalString(CodePostal codePostal) {
        return codePostal.getValue();
    }
}
